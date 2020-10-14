package com.java.bean;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-08-31 22:07
 * @Modified By:
 */
public class RestDay {
    private  int year;
    private  int month;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "RestDay{" +
                "year=" + year +
                ", month=" + month +
                '}';
    }
}
