package com.zx.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

public abstract class SqlSessionUtil {

    //1. 找到核心配置文件
    public static final String config = "mybatis.xml";

    private static  final SqlSessionFactory sqlSessionFactory;
    static{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = null;
        InputStream in = null;
        try {
            //将核心配置文件 转化为 流对象  便于解析
            in = Resources.getResourceAsStream(config);
            //2. 创建构建器  用于SqlSessionFactory 工厂对象
            sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3. 使用构建器 创建sql会话工厂
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
    }

    /**
     * 方法名：getSqlSession
     * 描述： 打开一个sql 会话对象
     *          注意 在mybatis中 每次创建一个SqlSession时 都会单独的打开一个事务
     *          并且这个事务设置的是不会自动提交的事务
     * 作者： Mr.T
     * 时间： 2020-03-03 14:48
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }


}
