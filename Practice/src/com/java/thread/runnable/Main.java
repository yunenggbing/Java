package com.java.thread.runnable;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-05 21:47
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Runnable r =  new Runnable();
        Thread t =  new Thread();
        t.start();

        for (int i = 0 ;i<10;i++){
            System.out.println("哈哈哈"+i);

        }
    }
}
