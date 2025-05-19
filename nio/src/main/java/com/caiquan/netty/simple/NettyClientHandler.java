package com.caiquan.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 连接成功后干的事情
     * <p>
     * 发送数据
     *
     * @param ctx
     * @return
     * @author  CarpCap
     * @date 2020/12/12 23:31
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("准备发送数据了");
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("hello server ", CharsetUtil.UTF_8));
    }

    /**
     * 当通道有读取事件时 会触发
     * 打印服务器回复的信息
     *
     * @param ctx
     * @param msg
     * @return
     * @author  CarpCap
     * @date 2020/12/12 23:33
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器回复消息：" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("服务器地址：" + ctx.channel().remoteAddress());
    }


    /**
     * 发生异常情况执行
     *
     * 关闭通道
     *
     * @param ctx
     * @param cause
     * @return
     * @author  CarpCap
     * @date 2020/12/12 23:36
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();

    }
}
