package com.tinnkm.wechat.fileupload.service;

import com.tinnkm.wechat.fileupload.entry.User;

import java.util.Map;

/**
 * @author tinnkm
 * @version 1.0
 * @classname UserService
 * @description 用户服务层
 * @date 2018/11/3 18:55
 **/
public interface UserService {

    /**
     * 保存用户，并返回token
     * @param user 用户实体类
     * @return 返回userId和token
     */
    Map<String,String> saveUser(User user);
}
