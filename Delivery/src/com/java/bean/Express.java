package com.java.bean;

import java.util.Objects;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-08-30 17:33
 * @Modified By:
 */
public class Express {
    //单号
    private  String num;
    //快递公司
    private  String company;
    //取件码
    private  int code;
    //位置
    private  int[][] pos;

    public Express() {
    }

    public Express(String num, String company, int code, int [][] pos) {
        this.num = num;
        this.company = company;
        this.code = code;
        this.pos = pos;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPos(int [][] pos) {
        this.pos = pos;
    }

    public String getNum() {
        return num;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Express express = (Express) o;
        return Objects.equals(num, express.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    public int  getCode() {
        return code;
    }

    public int [][] getPos() {
        return pos;
    }



}
