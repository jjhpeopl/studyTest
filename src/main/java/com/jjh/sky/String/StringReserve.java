package com.jjh.sky.String;

/**
 * Created by jiajianhong on 17/3/7.
 */
public class StringReserve {

    public static void main(String[] args) {
        Long l = 103420L;

        Long result = 0L;

        long num = 0;

        while (l > 0) {
            result = result * 10;

            result = result + l % 10;

            l = l / 10;

            num ++;
        }

        System.out.println(num);
        System.out.println(result);
        System.out.println(result.toString().length());

        String temp = "";
        for (;num > result.toString().length();num --) {
            temp = "0" + result.toString();
        }
        System.out.println(temp);


        Long l1 = 103420L;
        StringBuffer sb = new StringBuffer("0023010");
        System.out.println(sb.reverse().toString());
    }



}
