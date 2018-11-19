package com.tinnkm.wechat.fileupload.controller;

import com.tinnkm.wechat.fileupload.entry.User;
import com.tinnkm.wechat.fileupload.service.UserService;
import com.tinnkm.wechat.fileupload.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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

    @PostMapping("/save")
    public Result<Map<String,String>> save(User user){
        Map<String, String> map = userService.saveUser(user);
        if (null == map){
            return Result.error(HttpServletResponse.SC_CREATED,"用户已存在");
        }
        return Result.success("token获取成功",map);
    }
}
