package com.jjh.sky.singleton;

/**
 * Created by jiajianhong on 16/10/14.
 * 枚举
 * 这种方式不仅能避免多线程同步问题,而且还能防止反序列化重新创建的对象
 * 其实这种跟第三、四种有点类似,可以查看编译后的class文件
 */
public enum Singleton6 {

    INSTANCE;

    public void whateverMethod() {
        System.out.println("枚举单例");
    }

}
