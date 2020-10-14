package com.java.jehe.set;

import java.util.HashSet;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-02 21:34
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) {
        //HashSet   散列存放  哈希表
        HashSet<String> set = new HashSet<>();
        boolean flag1 = set.add("哈哈哈"); //flag1为true
        set.add("啧啧啧");
        set.add("嘿嘿嘿");
        boolean flag2 =  set.add("哈哈哈"); //因为set集合不允许存放重复元素，所以这次add是失败的，flag2位false
        System.out.println(flag1);
        System.out.println(flag2);
        for (String s:set ) {
            System.out.println(s);
        }



    }
}

