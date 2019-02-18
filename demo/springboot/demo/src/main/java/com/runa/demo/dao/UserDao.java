package com.runa.demo.dao;

import com.runa.demo.pojo.User;

import java.util.List;

public interface UserDao {

    public List<User> selectAll();

    public void insert(User user);
}
