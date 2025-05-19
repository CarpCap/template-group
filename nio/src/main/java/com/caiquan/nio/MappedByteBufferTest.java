package com.caiquan.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  MappedByteBuffer 可以让文件直接在内存（堆外内存）中修改，操作系统不需要进行拷贝
 *
 * @author  CarpCap
 * @Title:
 * @Description:
 * @date 2020/11/19 19:43
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        //rw   r代表可读 w代表可写
        RandomAccessFile rw = new RandomAccessFile("C:\\test\\testFile\\1.txt", "rw");
        //获取通道
        FileChannel channel = rw.getChannel();

        //第一个参数代表使用的Map模式是读写模式
        //第二个参数 代表起始位
        //第三个参数 是映射到内存的大小，即将 1.txt 的多少个字节映射到内存。
        //可以直接修改的范围 0-4  不包含5
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0,(byte) 'q');
        map.put(2,(byte) 'w');

        channel.close();
        rw.close();

    }

}
