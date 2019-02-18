package com.runa.demo.controller;

import com.runa.demo.pojo.User;
import com.runa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/add/{userName}/{password}/{phone}")
    @ResponseBody
    public String add(@PathVariable String userName, @PathVariable String password, @PathVariable String phone) {
        User u = new User();
        u.setUserName(userName);
        u.setPassword(password);
        u.setPhone(phone);
        userService.insert(u);
        return "success";
    }

    @RequestMapping("/all/{pageNo}/{pageSize}")
    @ResponseBody
    public List<User> selectAll(@PathVariable String pageNo, @PathVariable String pageSize) {
        return userService.selectAll(pageNo, pageSize);
    }

    @RequestMapping("/testThy")
    public String TestThymeleaf(Model model) {
        model.addAttribute("a", "Welecome To Spring-Boot");
        return "test";
    }
}
