package com.java.jehe.arraylist;

import java.util.ArrayList;

/**
 * @Author: YNB
 * @Description:ArrayList
 * @Date Created in 2020-09-02 19:49
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) {
        //ArrayList
        ArrayList<String>  arrayList = new ArrayList<>();  //实例化对象
        //增加内容，此方法从Collection接口继承而来
        arrayList.add("Hello ");
        /// 增加内容，此方法是List接口单独定义的
        arrayList.add(0, "My");   //在第1的位置添加添加My
        String arr =  arrayList.get(0);   //顺序存储所以这里取得是My
        System.out.println(arrayList);
        System.out.println(arr);
        String  arr1 = arrayList.remove(1); //获得位置1上的的数据并将其删除，所以这里将Hello删除
        System.out.println(arr1);
        System.out.println(arrayList);



    }
}
