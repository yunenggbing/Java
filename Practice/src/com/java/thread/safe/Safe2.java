package com.java.thread.safe;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: YNB
 * @Description:显示锁Lock 子类  RentrantLock
 * @Date Created in 2020-09-05 23:13
 * @Modified By:
 */
public class Safe2 {
    public static void main(String[] args) {
        //

        Runnable r = new Ticket();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();

    }

    static class Ticket implements Runnable {
        private int count = 10;
        //        private  Object o = new Object();
        private Lock l = new ReentrantLock(true);  //设置为true则代表这把锁是公平锁

        @Override
        public void run() {
            while (true) {
                l.lock();
                if (count > 0) {
                    System.out.println("正在出票......");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "出票成功，余票为：" + count);
                }
                l.unlock();
            }
        }
    }

}
