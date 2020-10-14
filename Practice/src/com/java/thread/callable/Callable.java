package com.java.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-06 15:15
 * @Modified By:
 */
public class Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        java.util.concurrent.Callable<Integer> c = new Mycallable();
        FutureTask  f = new FutureTask(c);

        new Thread(f).start();
        Integer r = (Integer) f.get();
        System.out.println("返回值："+r);
        for(int i = 0; i <10;i++){
            Thread.sleep(1000);
            System.out.println(i);
        }


    }
    static  class  Mycallable implements java.util.concurrent.Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            for(int i = 0; i <10;i++){
                Thread.sleep(1000);
                System.out.println(i);
            }
            return 100;
        }
    }

}
