package com.java.view;


import java.util.Scanner;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-08-31 21:45
 * @Modified By:
 */
public class Views {
    Scanner input = new Scanner(System.in);

    /**
     * 欢迎界面
     */
    public void welcome() {
        System.out.println("------欢迎使用本系统------");
    }

    /**
     * 再见界面
     */
    public void bye() {
        System.out.println("------欢迎下次使用------");
    }

    /**
     * 获取年界面
     *
     * @return
     */
    public int years() {
        System.out.println("请输入年：");
        String year = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            return years();
        }
        return num;
    }

    /**
     * 获取月
     *
     * @return
     */

    public int months() {
        System.out.println("请输入月份：");
        String month = input.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(month);
        } catch (NumberFormatException e) {
            return months();
        }
        return num;
    }

    /**
     * 月休息天数
     *
     * @param num
     */
    public void monthDays(int num) {
        System.out.println("本月休息天数有：" + num + "天。");
    }

    /**
     * 月周末休息天数
     *
     * @param num
     */
    public void weekendDays(int num) {
        System.out.println("本月轮到周末休息天数是：" + num + "天。");
    }

    /**
     * 打印头
     */
    public void printHead() {
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
    }

    /**
     * 打印所有行
     *
     * @param week
     * @param sumday
     */
    public void printAll(int week, int sumday, int[] restday) {
        int count = 0;
        int n = 0;
        for (int j = 1; j <= sumday; j++) {
            count++;
            //打印空格
            for (int i = 0; i < week; i++) {
                System.out.print("\t\t");
                count++;
            }
            //输出空格之后必须将其值设为零
            week = 0;
            //输出数据
               if (restday[n] == j) {

                       System.out.print("[" + j + "]" + "\t\t");

                   n++;
               } else {
                   System.out.print(j + "\t\t");
               }

            //判断换行
            if (count % 7 == 0) {
                System.out.print("\n");
                count = 0;
            }
        }
        System.out.println();
    }
}
