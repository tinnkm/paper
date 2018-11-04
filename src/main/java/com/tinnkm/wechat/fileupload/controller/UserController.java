package com.tinnkm.wechat.fileupload.controller;

import com.tinnkm.wechat.fileupload.entry.User;
import com.tinnkm.wechat.fileupload.service.UserService;
import com.tinnkm.wechat.fileupload.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tinnkm
 * @version 1.0
 * @classname UserController
 * @description 用户控制类
 * @date 2018/11/4 15:40
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/save")
    public Result<String> save(User user){
        String token = userService.saveUser(user);
        return Result.success("token获取成功",token);
    }
}
