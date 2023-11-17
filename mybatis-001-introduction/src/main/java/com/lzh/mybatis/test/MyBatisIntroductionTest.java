package com.lzh.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSession sqlSession = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is); // 一般情况下都是一个数据库对应一个SqlSessionFactory对象。

//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

//        SqlSession sqlSession = sqlSessionFactory.openSession();

        int count = sqlSession.insert("insertCar");
        System.out.println("插入了几条：" + count);
//        sqlSession.commit();

    }
}
