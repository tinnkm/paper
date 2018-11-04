package com.tinnkm.wechat.fileupload.dao;

import com.tinnkm.wechat.fileupload.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author tinnkm
 * @version 1.0
 * @classname UserDao
 * @description 用户Dao
 * @date 2018/11/3 18:54
 **/
public interface UserDao extends JpaRepository<User, String>{
}
