package com.java.thread.dean;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-05 22:50
 * @Modified By:
 */
public class Dead {
    public static void main(String[] args) throws InterruptedException {
        Runnalbe r =  new Runnalbe();
        Thread t1 = new Thread(r);
        t1.setDaemon(true); //设置守护线程
        t1.start();
        for (int i = 0 ;i<6;i++){
            System.out.println(Thread.currentThread().getName()+i);
            Thread.sleep(1000);
        }
//        t1.interrupt(); //为t1线程打上标记


    }

    static  class  Runnalbe implements   Runnable{
        @Override
        public void run() {
            for (int i = 0 ;i<10;i++){
                System.out.println(Thread.currentThread().getName()+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("main方法结束，我也要结束");
                    return; //当发现线程被打上标记之后，就执行return跳出循环。
                }
            }
        }
    }
}
