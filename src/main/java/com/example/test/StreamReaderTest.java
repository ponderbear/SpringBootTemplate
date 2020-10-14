package com.example.test;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
public class StreamReaderTest {
    public static void main(String args[]){
//        1、字节数组的读取与输出 ByteArrayInputStream
        ByteArrayOutputStream ot = new ByteArrayOutputStream();
        try {
            System.out.println(Charset.defaultCharset());
            //字符串转UTF-8编码（default）的二进制表示
            ot.write("hello".getBytes());
            //输出字节数组
            byte[] ba = ot.toByteArray();
            ByteArrayInputStream bi = new ByteArrayInputStream(ba);
            //获取字节数组的长度
            int len = bi.read(ba);
            //输出字节数组的字符串，len位置是字节数组的长度
            System.out.println(new String(ba,0,len));

        } catch (IOException e) {
            log.info("没得问题");
            e.printStackTrace();
        }
    }
}
