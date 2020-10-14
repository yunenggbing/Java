package com.java.jehe.foreach;

import java.util.ArrayList;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-02 21:05
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) {
        //foreach  增强for循环
        //用于迭代数组或集合(Collection)
        //语法：for(数据类型  变量名:集合或数组名){}
        int num [] = {1,5,47,9,6};
        for (int n:num){
            System.out.println(n);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("哈哈哈");
        arrayList.add("啧啧啧");
        arrayList.add("嘿嘿嘿");
        for (String str:arrayList) {
            System.out.println(str);
        }
    }
}
