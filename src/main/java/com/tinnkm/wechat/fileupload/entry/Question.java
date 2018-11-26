package com.tinnkm.wechat.fileupload.entry;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author tinnkm
 * @version 1.0
 * @classname Question
 * @description 对应模板下的题目
 * @date 2018/11/3 13:09
 **/
@Data
@Table
@Entity
public class Question {
    /**
     * 主键
     */
    @Id
    @GenericGenerator(name="questionIdGenerator", strategy="uuid")
    @GeneratedValue(generator="questionIdGenerator")
    private String questionId;
    /**
     * 外键
     */
    @Column
    private String templateId;
    /**
     * 问题标题
     */
    @Column
    private String questionTitle;
    /**
     * 示例图片个数
     */
    @Column
    private Integer questionTemplateCount;
    /**
     * 示例类型（图片、文字）
     */
    private String questionTemplateType;
    /**
     * 问题示例
     */
    @Column
    private String questionTemplate;
    /**
     * 是否必须
     */
    @Column
    private boolean required;
}
