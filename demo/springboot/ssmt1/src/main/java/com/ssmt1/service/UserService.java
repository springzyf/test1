package com.ssmt1.service;

import com.ssmt1.pojo.User;
import java.util.List;

public interface UserService {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectById(int userId);

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     */
    void deleteUser(int userId);
}
