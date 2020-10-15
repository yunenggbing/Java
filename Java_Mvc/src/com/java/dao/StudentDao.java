package com.java.dao;

import com.java.bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-14 21:42
 * @Modified By:
 */
//定义操作数据库的方法
public interface StudentDao {

    //查询所有的学生
    public List<Student> getAll();

    //增加学生
    public List<Student> addStudent() throws SQLException;

    //删除指定信息的学生
    public  List<Student>  deleteStudent();

    //修改指定学生的信息
    public  List<Student> altStudent();
}
