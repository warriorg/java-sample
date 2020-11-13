package me.warriorg.springboot.controller;

import me.warriorg.springboot.model.User;
import me.warriorg.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author warrior
 */
@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{uid}")
    public User getByUid(@PathVariable String uid) {
        return userService.getByUid(uid);
    }
}
