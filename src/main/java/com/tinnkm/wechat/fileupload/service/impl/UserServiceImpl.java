package com.tinnkm.wechat.fileupload.service.impl;

import com.tinnkm.wechat.fileupload.dao.UserDao;
import com.tinnkm.wechat.fileupload.entry.User;
import com.tinnkm.wechat.fileupload.jwt.config.Audience;
import com.tinnkm.wechat.fileupload.jwt.utils.JwtUtils;
import com.tinnkm.wechat.fileupload.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tinnkm
 * @version 1.0
 * @classname UserServiceImpl
 * @description 用户服务类具体实现
 * @date 2018/11/3 18:57
 **/
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final Audience audience;
    @Autowired
    public UserServiceImpl(UserDao userDao, Audience audience) {
        this.userDao = userDao;
        this.audience = audience;
    }

    @Override
    public String saveUser(User user) {
        userDao.save(user);
        // 生成token
        return JwtUtils.createToken(user.getUserName(),user.getUserId(),user.getRole(),audience.getClientId(),audience.getName(),audience.getExpires()*1000,audience.getSecret());
    }
}
