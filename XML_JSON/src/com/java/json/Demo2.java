package com.java.json;

import com.google.gson.Gson;

/**
 * @Author: YNB
 * @Description:Gson
 * @Date Created in 2020-09-10 23:14
 * @Modified By:
 */
public class Demo2 {
    public static void main(String[] args) {
        /**
         * 字符串转JSON
         */
        //1、创建Gson对象
        Gson g = new Gson();
        //2、转换  {"id":"1001","name":"西游记","info":"西天取经的故事"}
       Book b = g.fromJson("{\"id\":\"1001\",\"name\":\"西游记\",\"info\":\"西天取经的故事\"}",Book.class);
        System.out.println(b.getId());
    }
}
