package com.caiquan.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * SimpleChannelInboundHandler 是ChannelInboundHandler子类
 * HttpObject 表示客户端和服务器端相互通讯的数据被封装成 HttpObject类型
 *
 * @author  CarpCap
 * @date 2021/1/22 15:24
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 读取客户端数据
     *
     * @author  CarpCap
     * @date 2021/1/22 15:24
     * @param channelHandlerContext
     * @param httpObject
     * @return
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {

        //判断 msg 是不是 httprequest
        if (httpObject instanceof HttpRequest){
            // TODO: 2021/9/1  这里有个很奇怪的问题 按照正常来说 每一次请求对应的pipeline与handler应该是不同的，
            //  但是我用apple safari浏览器刷新请求发现竟然是一样的，谷歌浏览器不一样
            
            System.out.println("pipeline hashcode:" + channelHandlerContext.pipeline().hashCode());
            System.out.println("handler hashcode :" + this.hashCode());
            System.out.println("msg 类型="+httpObject.getClass());
            System.out.println("客户端地址:"+channelHandlerContext.channel().remoteAddress());


            //通过uri过滤特定的资源
            HttpRequest httpRequest= (HttpRequest) httpObject;
            //获取uri
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求了favicon.ico,不做响应");
                return;
            }

            //回复信息给浏览器 [http 协议]
            ByteBuf content = Unpooled.copiedBuffer("hello,My is Server", CharsetUtil.UTF_8);

            //构造一个http的响应，httpresponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());

            //将构建好的response返回
            channelHandlerContext.writeAndFlush(response);
        }
    }
}
