package com.ssmt1.service.impl;

import com.ssmt1.mapper.UserMapper;
import com.ssmt1.pojo.User;
import com.ssmt1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(int userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userMapper.deleteUser(userId);
    }
}
