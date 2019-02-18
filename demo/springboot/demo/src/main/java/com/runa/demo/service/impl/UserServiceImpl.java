package com.runa.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.runa.demo.dao.UserDao;
import com.runa.demo.pojo.User;
import com.runa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAll(String pageNo, String pageSize) {
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        List<User> users = userDao.selectAll();
        return users;
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }
}
