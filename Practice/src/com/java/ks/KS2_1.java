package com.java.ks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-08 14:39
 * @Modified By:
 */
public class KS2_1 {
    /*
    1、使用任何一种方法对List集合中的元素进行排序
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(2);
        list.add(10);
        list.add(18);
        list.add(15);
        Collections.sort(list);
        System.out.println(list.toString());
    }
}
