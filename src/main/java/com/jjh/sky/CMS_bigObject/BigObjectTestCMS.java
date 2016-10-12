package com.jjh.sky.CMS_bigObject;

import java.util.ArrayList;

/**
 * Created by jjh on 16/10/11.
 * -verbose:gc
 -Xms100M
 -Xmx100M
 -Xmn30M
 -XX:+PrintGCDetails
 -XX:SurvivorRatio=8
 -XX:+UseConcMarkSweepGC
 -XX:+UseParNewGC
 -XX:+PrintCommandLineFlags
 */
public class BigObjectTestCMS {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {



        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start");
        byte[] longs = new byte[24 * _1MB];

        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
