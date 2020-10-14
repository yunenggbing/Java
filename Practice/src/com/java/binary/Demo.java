package com.java.binary;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-16 20:03
 * @Modified By:
 */
public class Demo {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,8,12,15,16,26,35};
        int target = 12;
        int max = arr.length -1;
        int min = 0;
        while (min <=max){

            int middle = (max + min)/2;
            if (arr[middle] > target){
                max = middle - 1;
            }else if(arr[middle] < target){
                min = middle + 1 ;
            }else if (arr[middle] == target){
                System.out.println(target+"找到了，位置是："+middle);
                break;
            }
        }
    }
}
