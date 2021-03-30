package com.carl;

import com.carl.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/0:20
 * @Description:
 */
public class TestMyBatis {
    @Test
    public void testInsert() throws IOException {
        //访问mybatis读取student数据
        //定义mybatis主配置文件的名称，从类路径的根开始
        String config = "mybatis.xml";

        //读取config表示的文件
        InputStream is = Resources.getResourceAsStream(config);

        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(is);

        //**重要**获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //**重要**指定要执行的sql语句的标识，sql映射文件中的namespace + “.” + 标签的id值
        String sqlId = "com.carl.dao.StudentDao" + "." + "insertStudent";

        Student student = new Student(1003, "王五", "zf@163.com", 35);

        //执行sql语句，通过sqlId找到语句
        int numbers = sqlSession.insert(sqlId,student);

        //mybatis默认不自动提交事务，因此需要在insert，update，delete后要手动提交事务
        sqlSession.commit();

        //输出结果
        System.out.println("执行insert的结果= " + numbers);

        //关闭sqlSession对象
        sqlSession.close();
    }
}
