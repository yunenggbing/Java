package com.java.thread.safe;


/**
 * @Author: YNB
 * @Description:同步代码块
 * @Date Created in 2020-09-05 23:13
 * @Modified By:
 */
public class Safe {
    public static void main(String[] args) {
        //synchronized (所对象){}

         java.lang.Runnable  r = new Ticket();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();

    }

    static  class    Ticket implements   Runnable{
        private int count = 10;
        private  Object o = new Object();
        @Override
        public void run() {
           while(true) {
               synchronized (o) {
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
               }
           }
        }
    }

}
