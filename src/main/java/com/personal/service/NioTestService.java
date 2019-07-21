package com.personal.service;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * @author : YangChunLong
 * @date : Created in 2019/7/10 22:06
 * @description: Nio 测试类
 * @modified By:
 * @version: :
 */
public class NioTestService {
    private static final String FILE_PATH = "/Users/haokan/Home/ycl/niotest.txt";
    public static void write(int i){
    }

    public static void main(String[] args) {
        String testStr = "hellonio";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        byteBuffer.put(testStr.getBytes());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        byteBuffer.flip();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println(byteBuffer.get(i));
        }
        System.out.println(byteBuffer.getChar(0));
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        byte[] b = new byte[byteBuffer.limit()];
        byteBuffer.get(b);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        byteBuffer.rewind();
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        byteBuffer.clear();
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        System.out.println((char)byteBuffer.get());
    }
}
