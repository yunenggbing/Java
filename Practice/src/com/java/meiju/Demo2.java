package com.java.meiju;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-11 20:19
 * @Modified By:
 */
public enum Demo2 implements  DShow {

    LOW {
        @Override
        public void show () {
            System.out.println("低级别");
        }
    },MEDIUM{
        @Override
        public void show () {
            System.out.println("中级别");
        }
    },HIGH{
        @Override
        public void show () {
            System.out.println("高级别");
        }
    }


}

interface  DShow{
    void show();
}
