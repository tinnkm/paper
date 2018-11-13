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
    /**
     * 根据身份证号判断用户是否存在
     * @param idCard 身份证号
     * @return 是否存在
     */
    boolean existsByIdCard(String idCard);
}
