package com.carl.dao;

import com.carl.domain.Student;

import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/03/29/13:21
 * @Description: 接口操作Student表
 */
public interface StudentDao {

    //查询student表的所有数据
    public List<Student> selectStudents();

    //插入方法
    //参数：student，标识要插入到数据库的数据
    //返回值int，表示执行insert操作后的影响数据的行数
    public int insertStudent(String student);
}
