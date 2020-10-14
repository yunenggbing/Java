package com.java.thread.runnable;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-05 21:43
 * @Modified By:
 */
public class Runnable  implements java.lang.Runnable {
    @Override
    public void run() {
        //实现Runnable中的run（）方法。
        for (int i = 0 ;i<10;i++){
            System.out.println("哈哈哈"+i);
        }

    }
}
