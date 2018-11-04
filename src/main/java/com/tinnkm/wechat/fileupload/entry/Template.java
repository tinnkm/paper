package com.tinnkm.wechat.fileupload.entry;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author tinnkm
 * @version 1.0
 * @classname Template
 * @description 上传模板类型
 * @date 2018/11/3 13:04
 **/
@Data
@Entity
@Table
public class Template {
    /**
     * 上传的模板分类
     */
    @Id
    private String templateId;
    /**
     * 上传的模板名
     */
    @Column
    private String templateName;
    /**
     * 上传模板描述
     */
    @Column
    private String templateDesc;
}
