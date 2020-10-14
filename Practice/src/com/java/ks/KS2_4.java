package com.java.ks;

import java.util.Scanner;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-08 15:03
 * @Modified By:
 */
public class KS2_4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("请输入三个数字：");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();

        //判断数字大小
        if (num1 >num2 && num2 > num3){
            //System.out.println(num1+">"+num2+">"+num3);
            System.out.println(num3+"<"+num2+"<"+num1);
        }else if(num1 >num2 && num1 > num3 && num2< num3){
//            System.out.println(num1+">"+num3+">"+num2);
            System.out.println(num2+"<"+num3+"<"+num1);
        }else if (num2 >num1 && num1 > num3){
//            System.out.println(num2+">"+num1+">"+num3);
            System.out.println(num3+"<"+num1+"<"+num2);
        }else if(num2 >num1 && num2 > num3 && num1< num3){
//            System.out.println(num2+">"+num3+">"+num1);
            System.out.println(num1+"<"+num3+"<"+num2);
        }if (num3 >num1 && num1 > num2){
//            System.out.println(num3+">"+num1+">"+num2);
            System.out.println(num2+"<"+num1+"<"+num3);
        }else if(num3 >num1 && num3 > num2 && num1< num2){
//            System.out.println(num3+">"+num2+">"+num1);
            System.out.println(num1+"<"+num2+"<"+num3);
        }

    }
}
