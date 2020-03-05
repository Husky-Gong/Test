package com.zx.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zx.dao.IUserDao;
import com.zx.pojo.User;
import com.zx.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //1. get sqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        Page<User> page = PageHelper.startPage(2,3);
        List<User> list = userDao.selectAll();
        for (User user: list) {
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
