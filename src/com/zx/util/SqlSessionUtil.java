package com.zx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public abstract class SqlSessionUtil {
    // 1. get configuration file
    public static final String config = "mybatis.xml";
    private static  final SqlSessionFactory sqlSessionFactory;
    static{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = null;
        InputStream in = null;

        try {
            // 2. transfer xml file into stream object
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3. create factory builder
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 4. create sql factory
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
