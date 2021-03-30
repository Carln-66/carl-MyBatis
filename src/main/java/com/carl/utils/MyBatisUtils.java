package com.carl.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/0:37
 * @Description:
 */
public class MyBatisUtils {

    private static SqlSessionFactory factory = null;

    static {
        String config = "mybatis.xml";  //需要和项目中的resource文件名一样
        try {
            InputStream is = Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //创qlSession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession();  //非自动提交事务
        }
        return sqlSession;
    }
}
