package com.zx.dao;

import com.zx.pojo.User;

import java.util.List;

public interface IUserDao {
    User selectUser(Integer id);

    List<User> selectAll();

    void insert(User user);

    void update(User user);

    void delete(Integer id);
}
