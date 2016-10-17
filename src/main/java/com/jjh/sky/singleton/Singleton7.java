package com.jjh.sky.singleton;

/**
 * Created by jiajianhong on 16/10/14.
 * 这是第二种方式的升级版,俗称双重检查锁定
 * 参考资料:http://www.ibm.com/developerworks/cn/java/j-dcl.html
 */
public class Singleton7 {

    private Singleton7(){}

    private static volatile Singleton7 instance;

    public static Singleton7 getInstance() {
        if (instance == null) {
            synchronized (Singleton7.class) {
                if (instance == null) {
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }

}
