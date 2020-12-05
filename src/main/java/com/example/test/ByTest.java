package com.example.test;

import java.io.UnsupportedEncodingException;

public class ByTest {

    public static void main(String args[]) throws UnsupportedEncodingException {
        String str="wrt";
        System.out.println("utf-8编码的长度");
        System.out.println(str.getBytes().length);
        System.out.println(str.getBytes());
        for(byte i : str.getBytes()){
            System.out.print(i);
        }

        //再解码时（按照两个字节读取），剩下一个无法识别，用特殊符号代替，使得原有信息丢失，无法恢复
        String str2 = new String(str.getBytes(),"gbk");
        System.out.println(new String(str2.getBytes("gbk"),"utf-8").toString());
        System.out.println(str2);
    }
}
