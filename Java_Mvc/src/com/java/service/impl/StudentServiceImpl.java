package com.java.service.impl;

import com.java.bean.Student;
import com.java.dao.StudentDao;
import com.java.dao.impl.StudentImpl;
import com.java.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-14 22:09
 * @Modified By:
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao student = new StudentImpl();

    @Override
    public List<Student> getAll() {
        return student.getAll();
    }

    @Override
    public List<Student> addStudent() throws SQLException {
        return student.addStudent();
    }

    @Override
    public List<Student> deleteStudent() {
        return student.deleteStudent();
    }

    @Override
    public List<Student> altStudent() {
        return student.altStudent();
    }
}
