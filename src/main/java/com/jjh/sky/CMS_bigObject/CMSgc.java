package com.jjh.sky.CMS_bigObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiajianhong on 17/4/27.
 */
public class CMSgc {

    public static void main(String[] args) {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        allocateMemory();
        try {
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void allocateMemory() {
        List<byte[]> list = new ArrayList<byte[]>();
        int size = 1024 * 1014 * 480;
        int len = size / (20 * 1024);
        for (int i = 0; i < len; i ++) {
            try {
                byte[] bytes = new byte[20 * 1024];
                list.add(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
