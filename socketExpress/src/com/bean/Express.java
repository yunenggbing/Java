package com.bean;

import java.io.Serializable;
import java.util.Objects;

public class Express implements Serializable {
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

    public String getCompany() {
        return company;
    }

    public int getCode() {
        return code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCompany(String company) {
        this.company = company;
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
        return Objects.equals(id, express.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
