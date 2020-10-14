package com.java.thread.firstthread;

/**
 * @Author: YNB
 * @Description:继承Thread
 * @Date Created in 2020-09-05 21:15
 * @Modified By:
 */
public class Thread {
    public static void main(String[] args) {
        MyThread myThread  =  new MyThread();
        myThread.start();
        for (int i = 0 ;i<10;i++){
            System.out.println("嘿嘿嘿"+i);
        }
    }
}
