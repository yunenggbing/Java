package com.java.bean;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-14 21:37
 * @Modified By:
 */
//实体类 （JavaBean）
// 类名=数据表名   列名=属性名
public class Student {
    private String stuname;
    private String stunum;
    private int stuage;
    private String gradeid;

    public Student() {
    }

    public Student(String stuname, String stunum, int stuage, String gradeid) {
        this.stuname = stuname;
        this.stunum = stunum;
        this.stuage = stuage;
        this.gradeid = gradeid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    public String getGradeid() {
        return gradeid;
    }

    public void setGradeid(String gradeid) {
        this.gradeid = gradeid;
    }
}
