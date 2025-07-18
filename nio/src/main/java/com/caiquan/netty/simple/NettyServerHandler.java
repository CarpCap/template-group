package com.caiquan.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * 1.我们自定义1个Handler 需要继承Netty规定好的某个HandlerAdapter
 * 2.自定义的Handler 才能称之为Handler
 *
 * @author aa3
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * //读取数据事件 这里我们可以读取客户端发送的消息
     *
     * @param ctx 上下文对象，含有 管道pipeline，通道channel，地址
     * @param msg 客户端发送过来的数据
     * @return
     * @author  CarpCap
     * @date 2020/12/6 18:40
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        解决方案1 用户程序自定义的普通任务

        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(10 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~(>^ω^<)喵2", CharsetUtil.UTF_8));
                    System.out.println("channel code=" + ctx.channel().hashCode());
                } catch (Exception ex) {
                    System.out.println("发生异常" + ex.getMessage());
                }
            }
        });



        //解决方案2 : 用户自定义定时任务 -》 该任务是提交到 scheduleTaskQueue中

        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {

                try {
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~(>^ω^<)喵 schedule", CharsetUtil.UTF_8));
                    System.out.println("channel code=" + ctx.channel().hashCode());
                } catch (Exception ex) {
                    System.out.println("发生异常" + ex.getMessage());
                }
            }
        }, 5, TimeUnit.SECONDS);


        System.out.println("server ctx= " + ctx);

        //将 msg 转成一个ByteBuf
        //ByteBuf 是netty提供的 不是 NIO 的 ByteBuffer
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送消息是：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址：" + ctx.channel().remoteAddress());
    }

    /**
     * 数据读取完毕后的操作
     *
     * @param ctx 上下文
     * @return
     * @author  CarpCap
     * @date 2020/12/6 18:44
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //代表把数据写入缓冲区 并且 刷新（把缓冲区数据写入到管道）
        //一般需要编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~ 客户端~(>^ω^<)喵1", CharsetUtil.UTF_8));
    }

    /**
     * 异常处理
     *
     * @param ctx
     * @param cause
     * @return
     * @author  CarpCap
     * @date 2020/12/6 18:47
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("close channel");
        //一般处理 这里是关闭通道
        ctx.channel().close(); //  ctx.close() 一样的效果
    }
}
