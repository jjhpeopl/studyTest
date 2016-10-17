package com.jjh.sky.singleton;

/**
 * Created by jiajianhong on 16/10/14.
 * 懒汉,线程安全
 * 这种方式不仅可以实现懒加载,同时多线程情况下也是安全的,但是效率比较低下,99%的情况不需要同步
 */
public class Singleton2 {

    private Singleton2(){}

    private static Singleton2 instance;

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}
