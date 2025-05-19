package com.caiquan.nio;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel01 {
    /**
     * 写数据到文件
     *
     * @author  CarpCap
     * @date 2020/11/18 23:30
     * @param args
     * @return
     */
    public static void main(String[] args) throws IOException {
        String str= "hello world";
        //创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\test\\01.txt");
        //通过输出流获得通道
        //这个fileChannel是一个抽象类型，实现类为FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将str 以字节put到Buffer中
        byteBuffer.put(str.getBytes());

        //对byteBuffer 进行反转 因为现在准备读Buffer的数据了
        byteBuffer.flip();
        //注意逻辑比较难理清楚
        //write方法代表将buffer写入通道中  而不是通道写入Buffer
        fileChannel.write(byteBuffer);

        //关闭
        fileOutputStream.close();
    }
}
