package com.example.test;

import java.io.UnsupportedEncodingException;

public class Bytes {
    public static void main(String args[]) throws UnsupportedEncodingException {
        String a ="中文";
        byte[] pB = new byte[0];
        try {
            //1、对unicode“中文”得十六进制表示按照gbk字符编码
            pB = a.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for(int i = 0;i < pB.length;i++){
            System.out.print(pB[i]);
        }

        String ns = null;
        try {
            //2、对按照gbk字符编码的二进制存储按照gbk的编码格式解码
            ns = new String(pB,"gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(ns);

        String us = null;
        try {
            //3、对按照gbk字符编码的二进制存储按照utf-8的编码格式解码
            us = new String(pB,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(us);

        String str="券";
        String str2 = new String(str.getBytes(),"gbk");


        System.out.println(new String(str2.getBytes(""),"gbk").toString());
        System.out.println(str2);


    }
}
