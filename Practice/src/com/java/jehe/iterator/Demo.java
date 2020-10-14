package com.java.jehe.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: YNB
 * @Description:Iterator
 * @Date Created in 2020-09-02 20:50
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) {
        //Iterator  迭代器
        //ListIterator

        ArrayList<String> arrayList = new ArrayList<>();  //实例化对象
        //增加内容，此方法从Collection接口继承而来
        arrayList.add("Hello ");
        /// 增加内容，此方法是List接口单独定义的
        arrayList.add(0, "My");   //在第1的位置添加添加My
        arrayList.add("HAHA ");
        arrayList.add("World ");

        Iterator<String> iterator =  arrayList.iterator(); //需要使用其他的集合对象调用
        //输出arraylist
        while(iterator.hasNext()){ //iterator.hasNext()判断下一个是否有值，有就返回true，否则false
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
