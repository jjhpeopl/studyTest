package com.jjh.sky.CMS_bigObject;

import java.util.ArrayList;

/**
 * Created by jjh on 16/10/11.
 */
public class BigObjectTestCMS {

    public static void main(String[] args) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start");
        long[] longs = new long[100000];

        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
