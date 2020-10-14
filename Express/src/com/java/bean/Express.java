package com.java.bean;

import java.util.Objects;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-03 19:13
 * @Modified By:
 */
public class Express {
    private String id;
    private String company;
    private int code;

    public Express() {
    }

    public Express(String id, String company, int code) {
        this.id = id;
        this.company = company;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Express{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Express express = (Express) o;
        return code == express.code &&
                id.equals(express.id) &&
                company.equals(express.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, code);
    }
}
