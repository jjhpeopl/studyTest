package com.jjh.sky.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jiajianhong on 16/9/9.
 */
public class ArrayListThread implements Runnable {

//    List<String> list = new ArrayList<String>();

    List<String> list = Collections.synchronizedList(new ArrayList<String>());

//    ConcurrentHashMap hashMap = new ConcurrentHashMap();

    public void run() {

        try {
            Thread.sleep((int) Math.random() * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        hashMap.put(Thread.currentThread().getName(), Thread.currentThread().getName());
        list.add(Thread.currentThread().getName());

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("arrayListThread");
        ArrayListThread arrayListThread = new ArrayListThread();

        try {
            for (int i = 0; i < 50; i++) {
                Thread thread = new Thread(threadGroup, arrayListThread, String.valueOf(i));
                thread.start();
            }

            while (threadGroup.activeCount() > 0) {
                Thread.sleep(1L);
            }

            System.out.println(arrayListThread.list.size());
//        System.out.println(arrayListThread.hashMap.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
