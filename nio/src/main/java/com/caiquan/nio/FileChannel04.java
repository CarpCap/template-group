package com.caiquan.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/11/19 19:22
 */
public class FileChannel04 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream=new FileInputStream("C:\\test\\testFile\\1.jpg");
        FileChannel channel1 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream=new FileOutputStream("C:\\test\\testFile\\2.jpg");
        FileChannel channel2 = fileOutputStream.getChannel();

        //将channel1拷贝到channel2中
        channel2.transferFrom(channel1,0,channel1.size());


        //关闭
        channel1.close();
        channel2.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
