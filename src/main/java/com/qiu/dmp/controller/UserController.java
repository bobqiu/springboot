package com.qiu.dmp.controller;

import com.qiu.dmp.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/8/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setUsername(String.valueOf(id));
        user.setPassword("password");
        return user;
    }
}
