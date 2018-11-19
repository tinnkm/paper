package com.tinnkm.wechat.fileupload.entry;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author tinnkm
 * @version 1.0
 * @classname Answer
 * @description 用户上传详情
 * @date 2018/11/3 13:21
 **/
@Data
@Table
@Entity
public class AnswerDetail {
    /**
     * 主键
     */
    @Id
    @GenericGenerator(name="answerDetailIdGenerator", strategy="uuid")
    @GeneratedValue(generator="answerDetailIdGenerator")
    private String answerDetailId;
    /**
     * 外键
     */
    @Column
    private String templateId;
    /**
     * 外键
     */
    @Column
    private String questionId;
    /**
     * 外键
     */
    @Column
    private String userId;
    /**
     * 是否有附件
     */
    @Column
    private boolean hasAttachment;
    /**
     * 附件相对地址
     */
    @Column
    private String attachmentPath;
    /**
     * 是否回答
     */
    @Column
    private boolean answered;
    /**
     * 答案
     */
    @Column
    private String answer;
}
