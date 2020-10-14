package com.java.ks;

import java.util.Arrays;

/**
 * @Author: YNB
 * @Description:使用冒泡算法对一组数据进行排序
 * @Date Created in 2020-10-08 14:54
 * @Modified By:
 */
public class KS2_3 {

    public static void main(String[] args) {

        Integer  [] arr = {2,32,21,12,14,9,25};
        for (int i = 0; i< arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i] > arr[j]){
                    Integer tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
