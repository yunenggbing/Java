package com.java.dao;

import com.java.bean.RestDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-08-31 22:38
 * @Modified By:
 */
public class RestDao {
    RestDay restday = new RestDay();

    /**
     * 判断是否是闰年
     * @param year
     * @return
     */
    /*
    public  boolean  isLeapYear(int year){
        if((year % 4 == 0 && year % 100 !=0) ||(year % 400 == 0) ){
            return true;
        }else {
            return false;
        }
    }
*/
    /**
     * 找出这个月一号是星期几
     * @return
     */
    public int  findweek(int year,int month){
        //日历变量
        Calendar c = Calendar.getInstance();
        //设置年
        c.set(Calendar.YEAR,year);
        //设置月
        c.set(Calendar.MONTH,month-1);
        //设置本月第一天为1
        c.set(Calendar.DATE,1);
        //得到第一天是星期几
        int week = c.get(Calendar.DAY_OF_WEEK)-1;
        return week;
    }

    /**
     * 找出这个月一共多少天
     * @param year
     * @param month
     * @return
     */
    public  int  findDaySum(int year,int month){
        int sumday =0;
        /*方法一
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:{
                sumday = sumday + 31;
                break;
            }
            case 2:{
                if(bool == true){
                    sumday =  sumday +29;
                }else{
                    sumday =  sumday +28;
                }
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11:{
                sumday  = sumday +30;
                break;
            }
        }
        */
        //方法二
        Calendar cl = Calendar.getInstance();
        cl.set(Calendar.YEAR, year);
        cl.set(Calendar.MONTH, (month - 1));   // 代码的0-11，表示日历的1-12月
        sumday = cl.getActualMaximum(Calendar.DAY_OF_MONTH);
        return sumday;
    }

    public  int[]  findDay(int year,int month,int sumday) throws ParseException {

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
            weekend ++;   // 以2020年2月为例，2020年2月2日未计入，2月2日为周7
        }
        return restDay2;
    }

}
