package com.tinnkm.wechat.fileupload.entry;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @Auther: tinnkm
 * @Date: 2018/11/5 17:39
 * @Description: mongoDb文件类
 * @since: 1.0
 */
@Document
@Data
public class File {
    @Id
    private String id;
    private String name;
    private String contentType;
    private Long size;
    private Date uploadDate;
    private String md5;
    private byte[] content;
    private String path;
    private String businessKey;
}
