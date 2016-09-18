package com.jjh.sky.thread;

/**
 * Created by jiajianhong on 16/9/13.
 * 卖票程序,利用Thread其实直接卖了30张票,资源没有共享
 */
public class ThreadTest {

    static class TicketThread extends Thread {

        // 一共十张票
        private int ticketNum = 10;

        @Override
        public void run() {

            for (int i = 0; i < 20; i ++) {
                if (this.ticketNum > 0) {
                    System.out.println("卖票 ticket:" + this.ticketNum --);
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketThread thread1 = new TicketThread();
        TicketThread thread2 = new TicketThread();
        TicketThread thread3 = new TicketThread();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
