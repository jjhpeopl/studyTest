package com.jjh.sky.thread;

/**
 * Created by jiajianhong on 16/9/13.
 * 卖票程序,利用Runnable可以实现资源共享,保证就卖了10张票
 */
public class RunnableTest {

    static class TicketThread implements Runnable {
        // 一共十张票
        private int ticketNum = 10;

        public void run() {

            for (int i = 0; i < 20; i ++) {
                if (this.ticketNum > 0) {
                    System.out.println("卖票 ticket:" + this.ticketNum --);
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketThread thread = new TicketThread();
        new Thread(thread).start();
        new Thread(thread).start();
        new Thread(thread).start();
    }

}
