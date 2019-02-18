package com.runa.demo.service;

import com.runa.demo.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> selectAll(String pageNo, String pageSize);

    public void insert(User user);
}
