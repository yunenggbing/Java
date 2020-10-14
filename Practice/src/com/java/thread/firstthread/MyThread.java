package com.java.thread.firstthread;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-05 21:24
 * @Modified By:
 */
public class MyThread  extends java.lang.Thread {
    /**
     * 继承Thread类之后需要重写run方法
     * run方法中的执行内容就是线程要执行的线程方法
     */
    @Override
    public void run() {
        //是一条新的执行路径
        //这个方法的触发方式，不是直接调用这个方法，而是需要i盗用start()方法来启动任务
        for (int i = 0 ;i<10;i++){
            System.out.println("哈哈哈"+i);
        }
    }
}
