package com.ssmt1.controller;

import com.ssmt1.pojo.User;
import com.ssmt1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> getAll(){
        return userService.selectAll();
    }

}
