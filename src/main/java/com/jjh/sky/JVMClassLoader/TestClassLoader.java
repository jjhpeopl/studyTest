package com.jjh.sky.JVMClassLoader;

/**
 * Created by jiajianhong on 17/3/21.
 */
public class TestClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
