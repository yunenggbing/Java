package com.java.jehe.likedlist;

import java.util.LinkedList;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-02 20:35
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) {
        //LikedList   双向链表  增加删除快，查找慢
        LinkedList<Integer> data = new LinkedList<>();

        //进栈
        data.push(100); //存入第一个数
        data.push(5001); //存入第二个数
        data.push(600);  // 存入第三个数
        System.out.println("原始数据："+data);//应该打印600  5001  100
        //出栈
        Integer num1 =  data.pop(); // 弹出第一个数得到600,此刻data：5001 100
        Integer num2 =  data.pop();// 弹出第一个数得到5001,此刻data： 100
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(data);
    }
}
