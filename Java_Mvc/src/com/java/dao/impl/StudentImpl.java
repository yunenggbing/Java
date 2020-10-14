package com.java.dao.impl;

import com.java.bean.Student;
import com.java.dao.StudentDao;
import com.java.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-14 21:44
 * @Modified By:
 */
//实现接口中的方法
public class StudentImpl extends DruidUtil implements StudentDao {
    @Override
    public List<Student> getAll() {
        List list = new ArrayList();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = getConnection();
            String sql = "select  * from student";
            preparedStatement = conn.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                String name = resultSet.getString("stuname");
                student.setStunum(resultSet.getString("stunum"));
                student.setStuname(resultSet.getString("stuname"));
                student.setStuage(resultSet.getInt("stuage"));
                student.setGradeid(resultSet.getInt("gradeid"));

                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,preparedStatement,resultSet);
        }

        return list;
    }
}
