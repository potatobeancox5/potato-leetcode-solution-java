package com.potato.study.leetcode;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {


    public static void main(String[] args) {

        SimpleDateFormat ss = new SimpleDateFormat("yyyy.MM.dd");
        long timeStamp = System.currentTimeMillis();

        String Time_0day = ss.format(new Date(timeStamp + 0 * 60 * 60 * 1000));
        String Time_11day = ss.format(new Date(timeStamp + 11 * 60 * 60 * 1000));
        System.out.print("0天数据------》"+Time_0day);
        System.out.print("11天数据------》"+Time_11day);
    }
}
