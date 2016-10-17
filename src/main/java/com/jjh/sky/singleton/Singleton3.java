package com.jjh.sky.singleton;

/**
 * Created by jiajianhong on 16/10/14.
 * 饿汉,线程安全
 * 这种方式基于classloader机制避免了多线程的问题,因为类加载时会判断此类是否加载过
 * 不过,instance在类加载时就实例化了,虽然导致类装载的原因有很多,在单例模式中大多数都是调用getInstance方法
 * 但是也不能确定有其他方式(或者其他静态方法)导致类装载,这时候初始化instance显然没有达到懒加载的效果
 */
public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    private Singleton3(){}

    public static Singleton3 getInstance() {
        return instance;
    }

}
