package com.example.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataTest {

    public static void main(String args[]){
        Date date = new Date();
        //时间戳：1970年到现在的总秒数
        // 默认精确到milliseconds，毫秒，默认到秒则/1000（或截掉后三位）
        System.out.println(date.getTime());
        System.out.println(date);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime localTime = LocalDateTime.now();
        System.out.println(localTime.toString());


        //SimpleDateFormat用于Date老式转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd : hh:mm:ss");
        String newDateTime = simpleDateFormat.format(date);
        System.out.println(newDateTime);


//        日期转换
//        注意格式化字符表示是固定的：MM是匹配月份，mm匹配分钟
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatTime = localTime.format(dateTimeFormatter);
        System.out.println(formatTime);


    }
}
