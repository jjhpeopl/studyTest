package com.jjh.sky.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jiajianhong on 16/9/28.
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> stringLinkedBlockingQueue = new LinkedBlockingQueue<String>();
        stringLinkedBlockingQueue.offer("jjh");
        try {
            System.out.println(stringLinkedBlockingQueue.take());
            System.out.println(stringLinkedBlockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
