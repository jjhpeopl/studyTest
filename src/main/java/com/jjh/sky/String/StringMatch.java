package com.jjh.sky.String;

/**
 * Created by jiajianhong on 17/3/21.
 */
public class StringMatch {

    public static void main(String[] args) {
        String mail = "abvcbadfa...@hotmail.com";
        String regex = "^[A-Za-z0-9]+([-_.]*[A-Za-z0-9]+)*[-_.]*@([A-Za-z0-9])+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]{2,5}$";

        System.out.println(mail.matches(regex));
    }

}
