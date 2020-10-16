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
    public int addStudent(String stuname, String stunum, String stuage, String gradeid) throws SQLException {
        return student.addStudent(stuname,stunum,stuage,gradeid);
    }

    @Override
    public int deleteStudent(String stuname, String stunum, String stuage, String gradeid) throws SQLException {
        return student.deleteStudent(stuname,stuname,stuage,gradeid);
    }

    @Override
    public int altStudent(String stuname, String stunum, String stuage, String gradeid) throws SQLException {
        return student.altStudent(stuname,stunum,stuage,gradeid);
    }

}
