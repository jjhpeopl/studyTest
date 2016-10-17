package com.jjh.sky.singleton;

/**
 * Created by jiajianhong on 16/10/14.
 * 静态内部类
 * 这种方式同样利用了classloader的机制来保证初始化instance时只有一个线程
 * 它跟第三、四种有细微的差别,第三、四种只要Singleton类被加载,instance就会被实例化,没有达到懒加载的效果
 * 而这种方式即使Singleton类被加载了,instance也不会初始化,因为SingletonHolder类没有被主动使用
 * 只有显示的调用了getInstance方法才会加载SingletonHolder类,从而实例化instance
 * 若实例化instance很消耗资源,想让他延时加载
 * 另外不希望Singleton类加载时就实例化,因为不能确保Singleton类在其他地方是否被主动使用而加载,这个时候实例化instance就不太合适了
 * 其实说白了,就是同时想实现懒加载的效果
 */
public class Singleton5 {

    private Singleton5(){}

    private static class SingletonHolder {
        private static final Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }

}
