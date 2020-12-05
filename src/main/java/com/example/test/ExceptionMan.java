package com.example.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class ExceptionMan {

    public static void main(String args[]) {
        System.out.println(testTry1());
        System.out.println(ifTest1());
    }

    public static int testTry1() {
        ArrayList<String> a = new ArrayList<>();
        try{
            System.out.println("try执行");
            //执行了return，但不返回值
            a.get(2);
            System.out.println(0);
            return 8;
        }catch(Exception e){
//            e.printStackTrace();
            System.out.println("catch执行");
        }
        return 3;
    }

    public static String ifTest1(){
        boolean t = true;
        if(t){
            System.out.println(JSONObject.toJSONString(null));
        }
        return "no if";
    }

}
