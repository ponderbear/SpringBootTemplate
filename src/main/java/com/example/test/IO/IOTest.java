package com.example.test.IO;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class IOTest {
    public static void main(String args[]) throws IOException {
        //java中的反斜杠是转义字符，windows中的路径就用\\或者/
        //用UTF-8对读取的二进制文件（文件是以二进制字符（Unicode）按照字符编码（UTF等）进行持久化存储）、进行编码字符还原读取成字符，然后读入内存
        byteArrayTest();
    }
    // 1、按照一个个字符从文件中读取，从二进制文本到字符
    public static void readFromFile() throws IOException {
        InputStreamReader r=null;
        try {
            r = new InputStreamReader(new FileInputStream("C:\\Users\\zheao\\Desktop\\test.txt"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            //两种：1、read()一个一个读出来，然后Char()强转；只能读一次，流是唯一的。
            // 2、read(char[]定义好的数组)，读进去，read的返回值依然用-1来判断
            int n;
            int Number = 0;
            while((n = r.read())!= -1){
                System.out.println((char)n);
                Number++;
            }
            System.out.println(n);
            System.out.println(Number);
            r.close();
        }
    }

    //2、以字符数组从文件中读取
    public static void readArrayFromFile() throws IOException {
        InputStreamReader r=null;
        try {
            r = new InputStreamReader(new FileInputStream("C:\\Users\\zheao\\Desktop\\test.txt"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            //两种：1、read()一个一个读出来，然后Char()强转；只能读一次，流是唯一的。
            int n;
            int Number = 0;
            //2、read(char[]定义好的数组)，读进去，read的返回值依然用-1来判断
            char[] cc = new char[1024];
            while((n = r.read(cc))!= -1){
                System.out.println(n);
            }
            //读出输出
            System.out.println(new String(cc));
            //统计字符长度
            System.out.println(Number);
            r.close();
        }
    }

//    3、按照缓冲区的方式从disk读取内存
    public static void bufferedReadFromFile() throws IOException {
        BufferedReader r=null;
        try {
            r = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\zheao\\Desktop\\test.txt"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            //两种：1、read()一个一个读出来，然后Char()强转；只能读一次，流是唯一的。
            int n;
            int Number = 0;
            //2、read(char[]定义好的数组)，读进去，read的返回值依然用-1来判断
            r.readLine();
            //读出输出
            System.out.println(new String());
            //统计字符长度
            System.out.println(Number);
            r.close();
        }
    }

    //ByteArrayInputStream用来读取  字节数组
    public static void byteArrayTest() throws IOException {

        byte[] b = "我的名字".getBytes("gbk");

        //注意中文字符，一个字符由多个字节组成；utf-8 一个中文字符占3个字节；gbk 一个中文字符占2个字节，不要在输入的时候截取部分
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
        int temp;
        while((temp = byteArrayInputStream.read())!= -1){
            System.out.println((char)temp);
            System.out.println((byte)temp);
//            byteArrayOutputStream.write((byte)temp);
        }


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(b);


        System.out.println(new String(byteArrayOutputStream.toByteArray(),"gbk"));


        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
//        PrintWriter printWriter = new PrintWriter(outputStreamWriter);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);


        //Wiriter有缓冲区，需要冲刷后，才能输出具体的字符。不然返回的是空对象的信息
//        System.out.println(new String(byteArrayOutputStream.toByteArray()));

        //Writer带有缓冲区，实现了flush方法；字节（一般只有带buffered的）和字符流（writer和reader）都可能由缓冲区，看是否实现了flush
        //byteArrayInputStream输出的是对象的位置值

        System.out.println(byteArrayInputStream.toString());

        byte[] prin = null ;
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        byteOutputStream.write(b);

        String outString = "输出字符";
        bufferedWriter.write(outString);
        //往上一层输入
//        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        //往控制台输入
        PrintWriter printWriter = new PrintWriter(System.out);


        printWriter.println("你好哦");
        //System 实际上是调用OutputStream
        System.out.println();
//        最后要冲刷，才能从Writer里刷走
        printWriter.flush();
    }
}
