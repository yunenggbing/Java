package com.java.jehe.vector;

import java.util.List;
import java.util.Vector;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-02 20:18
 * @Modified By:
 */
public class demo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(); //实例化对象
        List<String> vector1 =  new Vector<>(); //因为是List的子类，所以也可以直接用List进行实例化
        vector.add(10);
        vector.add(0,505);
        System.out.println(vector);
        int num = vector.size();  //获取长度
        System.out.println("长度:"+num);
    }

}
