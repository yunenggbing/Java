package com.java.dao.impl;

import com.java.bean.Student;
import com.java.dao.StudentDao;
import com.java.util.DruidUtil;

import java.sql.*;
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

    //读取所有学生信息
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
//                student.setGradeid(resultSet.getString("gradeid"));
                student.setGradeid(resultSet.getString("gradeid"));

                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,preparedStatement,resultSet);
        }

        return list;
    }

    //通过网页中的数据向数据表中添加
    @Override
    public int addStudent(String stuname,String stunum,String stuage,String gradeid) throws SQLException {

        Connection conn = null;
        conn = getConnection();
        Statement state = conn.createStatement();
        String sql = "insert into student values('"+stuname+"','"+stunum+"','"+stuage+"','"+gradeid+"')";
         int flag = state.executeUpdate(sql);
        state.close();
        conn.close();
//        System.out.println("返回:"+flag);
        return flag;
    }

    @Override
    public int  deleteStudent(String stuname, String stunum, String stuage, String gradeid) throws SQLException {
        Connection conn = null;
        conn = getConnection();
        Statement state = conn.createStatement();
        String sql = "DELETE from student where stuname='"+stuname+"' and stunum = '"+stunum+"' and stuage = '"+stuage+"'and gradeid = '"+gradeid+"'";
        int flag = state.executeUpdate(sql);
        state.close();
        conn.close();
//        System.out.println("返回:"+flag);
        return flag;
    }

    @Override
    public int  altStudent(String stuname, String stunum, String stuage, String gradeid) throws SQLException {
        Connection conn = null;
        conn = getConnection();
        Statement state = conn.createStatement();
        String sql = "update  student  set stuage='"+stuage+"', gradeid='"+gradeid+"'  where stuname='"+stuname+"' and stunum = '"+stunum+"' ";
        int flag = state.executeUpdate(sql);
        state.close();
        conn.close();
//        System.out.println("返回:"+flag);
        return flag;
    }


}
