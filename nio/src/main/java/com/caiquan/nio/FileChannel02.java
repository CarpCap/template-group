package com.caiquan.nio;



import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel02 {
    /**
     * 文件读数据到内存
     *
     * @author  CarpCap
     * @date 2020/11/18 23:30
     * @param args
     * @return
     */
    public static void main(String[] args) throws  Exception{
        //创建文件输入流
        File file=new File("C:\\test\\01.txt");
        FileInputStream fileInputStream=new FileInputStream(file);

        //获得通道
        FileChannel channel = fileInputStream.getChannel();

        //创建buffer
        ByteBuffer byteBuffer= ByteBuffer.allocate((int) file.length());

        //将通道的数据读到buffer
        channel.read(byteBuffer);

        //一次性获得全部字节数据 并且转成String打印
        System.out.println(new String(byteBuffer.array()));

        //关闭
        fileInputStream.close();


    }
}
