package com.java.json;

import com.google.gson.Gson;

/**
 * @Author: YNB
 * @Description:Gson
 * @Date Created in 2020-09-10 23:14
 * @Modified By:
 */
public class Demo1 {
    public static void main(String[] args) {
        /**
         * 字符串转JSON
         */
        //1、创建Gson对象
        Gson g = new Gson();
        //2、转换
        Book b = new Book("1001","西游记","西天取经的故事");
        String s = g.toJson(b);
        System.out.println(s);  //输出：{"id":"1001","name":"西游记","info":"西天取经的故事"}
    }
}
