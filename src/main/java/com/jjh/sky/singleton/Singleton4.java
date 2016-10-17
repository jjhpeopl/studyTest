package com.jjh.sky.singleton;

/**
 * Created by jiajianhong on 16/10/14.
 * 饿汉变种
 * 其实跟第三种方式差不多,都是在类初始化即实例化instance
 */
public class Singleton4 {

    private Singleton4(){}

    private static Singleton4 instance;

    static {
        instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return instance;
    }

}
