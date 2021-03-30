package com.carl;


import com.carl.domain.Student;
import com.carl.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/03/29/14:22
 * @Description:
 */
public class MyApp1 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //**重要**指定要执行的sql语句的标识，sql映射文件中的namespace + “.” + 标签的id值
        String sqlId = "com.carl.dao.StudentDao" + "." + "selectStudents";

        //执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);

        //输出结果
        studentList.forEach(stu -> System.out.println(stu));

        //关闭sqlSession对象
        sqlSession.close();
    }
}
