package com.jjh.sky.singleton;

/**
 * Created by jiajianhong on 16/10/14.
 * 懒汉,线程不安全
 * 这种方式可以实现懒加载,但是无法保证线程安全,在多线程执行的情况下会有问题
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1(){}

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}
