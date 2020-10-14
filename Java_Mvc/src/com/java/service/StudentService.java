package com.java.service;

import com.java.bean.Student;

import java.util.List;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-14 21:42
 * @Modified By:
 */
//定义操作数据库的方法
public interface StudentService {

    //查询所有的学生
    public List<Student> getAll();

}
