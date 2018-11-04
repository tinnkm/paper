package com.tinnkm.wechat.fileupload.entry;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author tinnkm
 * @version 1.0
 * @classname User
 * @description 用户信息实体
 * @date 2018/11/3 12:55
 **/
@Entity
@Table
@Data
public class User {
    /**
     * 用户id
     */
    @Id
    @GenericGenerator(name="userIdGenerator", strategy="uuid")
    @GeneratedValue(generator="userIdGenerator")
    private String userId;
    /**
     * 用户名
     */
    @Column
    private String userName;
    /**
     * 用户电话
     */
    @Column
    private String phone;
    /**
     * 用户身份证
     */
    @Column
    private String idCard;
    /**
     * 用户角色
     */
    @Column
    private String role;
}
