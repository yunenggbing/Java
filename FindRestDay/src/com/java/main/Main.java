package com.java.main;

import com.java.dao.RestDao;
import com.java.view.Views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-08-31 22:09
 * @Modified By:
 */
public class Main {

    public  static Scanner input =  new Scanner(System.in);
    public  static  Views v = new Views();
   public  static RestDao r = new RestDao();
    public static void main(String[] args) throws ParseException {

        v.welcome();
        int year =v.years();
        int month = v.months();
        int sumday = r.findDaySum(year,month);
        int [] restDay= r.findDay(year,month,sumday);
        int week = r.findweek(year,month);
        v.printHead();
        v.printAll(week,sumday,restDay);
        findDay(year,month,sumday);
        v.bye();
    }

    public  static  int[]  findDay(int year,int month,int sumday) throws ParseException {

        //设置日期格式
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-d");
        //第一个休息日
        String beginRestDay = "2020-2-2";
        //月的第一天
        String monthBeginDay = year+"-"+month+"-"+"1";
        //月的最后一天
        String monthEndDay =  year+"-"+month+"-"+sumday;
        //将字符串转为Date类
        Date beginRest = sd.parse(beginRestDay);
        Date  monthBegin =sd.parse(monthBeginDay);
        Date  monthEnd = sd.parse(monthEndDay);
        //算共有多少天休息日，用月末的时间去第一个休息日的时间，
        // 然后除以1000得到秒再除以60得到分钟再除以60得到小时再除以60得到天数
        int allRestDay = (int) ((monthEnd.getTime()-beginRest.getTime())/1000/60/60/24);

        //设置时间
        Calendar cbegin = Calendar.getInstance();
        Calendar cEnd = Calendar.getInstance();
        Calendar cRest = Calendar.getInstance();
        cbegin.setTime(beginRest);
        cEnd.setTime(monthEnd);
        cRest.setTime(beginRest);

        Date[] restDay = new Date[allRestDay];

        //上三休一，即第四天是休息日

        for (int i = 0; i < allRestDay/4; i++) {
            cRest.add(Calendar.DATE,4); // 上三休一
            Date d = cRest.getTime();   // 日期转换为日期类
            restDay[i] = d;          // 存放进数组
            // 显示休息日,以2020年2月为例，期望输出0206,0210,0214,0218,0222,0226...
            // System.out.println(s.format(allRestDay[i]));
        }

        // 只显示 指定月 的休息日
        int[] restDay1 = new int[allRestDay];
        int[] restDay2 = new int[allRestDay];
        Calendar c3 = Calendar.getInstance();
        int countRest = 0;

        for (int i = 0; i < allRestDay/4; i++) {
            c3.setTime(restDay[i]);
            // 指定 年月
            if ((cEnd.get(Calendar.YEAR) == c3.get(Calendar.YEAR))
                    && (cEnd.get(Calendar.MONTH) == c3.get(Calendar.MONTH))) {
                restDay1[i] = c3.get(Calendar.DATE);
                restDay2[countRest] = restDay1[i];    // 休息日日号放入新数组里
                countRest ++;

            }
        }

        //计算 休息日是周末的天数
        int weekend = 0;
        int temp = (year == 2020) && (month == 2)? (countRest-1) : countRest;

        for (int i = 0; i < temp; i ++) {
            String str = year+"-"+month+"-"+restDay2[i];
            Date weekRest = sd.parse(str);   //转换为date类型
            Calendar c4 = Calendar.getInstance();

            c4.setTime(weekRest);
            if((c4.get(Calendar.DAY_OF_WEEK) == 7)
                    || (c4.get(Calendar.DAY_OF_WEEK) == 1)){   // 周6、7为周末，代码数字为7、1
                weekend ++;
            }
        }

        if ((year == 2020) && (month == 2)) {
            weekend ++;// 以2020年2月为例，2020年2月2日未计入，2月2日为周7
            countRest ++;
        }
        System.out.println("本月休息天数有："+countRest+"天");
        System.out.println("本月轮到周末休息日有："+weekend+"天");
        return restDay2;
    }
}
