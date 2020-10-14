package com.java.jehe.map;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-02 23:21
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) {
        HashMap<String,String>  hashMap = new HashMap<>();
        hashMap.put("Key1","haha");
        hashMap.put("Key2","heihei");
        String str = hashMap.get("Key1");
        System.out.println(str);

        Set<String> data = hashMap.keySet();
        for (String s: data) {
            System.out.println(s+"-->"+hashMap.get(s));
        }
    }
}
