package com.jjh.sky.reflection;

import java.lang.reflect.Field;

/**
 * Created by jiajianhong on 16/9/18.
 */
public class IntegerReflection {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);
        array[132] = array[133];
        System.out.printf("%d",2 + 2);
    }

}
