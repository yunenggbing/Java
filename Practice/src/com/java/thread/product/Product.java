package com.java.thread.product;

/**
 * @Author: YNB
 * @Description:生产者与消费者
 * @Date Created in 2020-09-06 14:31
 * @Modified By:
 */
public class Product {

    public static void main(String[] args) {
        Food f = new Food();
        new Cook(f).start();
        new Waiter(f).start();
    }
    //厨师
    static  class  Cook extends  Thread{
        private  Food  f;

        public Cook(Food f) {
            this.f = f;
        }

        @Override
        public void run() {
           for(int i = 0;i<100;i++){
               if(i%2==0){
                   f.setNameAndTaste("麻辣香锅","麻辣味");
               }else{
                   f.setNameAndTaste("猪肉粉条","酸味");
               }
           }
        }
    }

    //服务员
    static  class  Waiter extends   Thread{
        private  Food  f;

        public Waiter(Food f) {
            for (int i= 0;i<100;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                f.get();
            }

        }

        @Override
        public void run() {
            super.run();
        }
    }

    //食物类
    static  class  Food{
        private  String name;
        private  String taste;
        private  boolean flag = true;
        public   synchronized  void  setNameAndTaste(String name,String taste) {
            if (flag) {
                this.name = name;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.taste = taste;
                flag = false;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void get() {
            if (!flag) {
                System.out.println("服务员端走的菜名是：" + name + ",味道是：" + taste);
                flag = true;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
