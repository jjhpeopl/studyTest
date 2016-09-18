package com.jjh.sky.list;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by jiajianhong on 16/9/9.
 */
public class GuavaLists {

    public static void main(String[] args) {
        // 生成的是线程不安全的
        List<String> list = Lists.newArrayList();
    }

}
