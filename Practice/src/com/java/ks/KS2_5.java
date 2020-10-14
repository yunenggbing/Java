package com.java.ks;


import java.util.Scanner;

/**
 * @Author: YNB
 * @Description:分别统计出其中英文字母、空格、数字和其它字符的个数。
 * @Date Created in 2020-10-08 15:19
 * @Modified By:
 */
public class KS2_5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一行字符：");

        char []  ch = {};

        //计算英文字母的个数
        int english = 0;
        //计算空格的个数
        int space = 0;
        //计算数字的个数
        int num = 0;
        //计算其他的个数
        int  other  = 0;

        String str = input.nextLine();
         ch = str.toCharArray();
        for (int i = 0;i < ch.length;i++){
            if (ch[i] >= 'a' && ch[i]<='z' || (ch[i] >= 'A' && ch[i] <= 'Z')){
                english +=1;
            }else if(ch[i] == ' '){
                space += 1;
            }else  if (ch[i] >= '0' && ch[i] <= '9'){
                num += 1;
            }else{
                other +=1;
            }
        }
        System.out.println(ch.length);
        System.out.println("英文字母的个数："+english);
        System.out.println("空格的个数："+space);
        System.out.println("数字的个数："+num);
        System.out.println("其他字符的个数："+other);
    }
}
