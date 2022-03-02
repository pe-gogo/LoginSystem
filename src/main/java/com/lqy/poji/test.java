package com.lqy.poji;


import com.lqy.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class test {

    public static UserMapper getUserMapper() throws IOException {
        SqlSession sql = getSession();
        return sql.getMapper(UserMapper.class);

    }

    public static SqlSession getSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sql = sqlSessionFactory.openSession();
        return sql;
    }
}
