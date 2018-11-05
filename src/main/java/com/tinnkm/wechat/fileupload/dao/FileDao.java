package com.tinnkm.wechat.fileupload.dao;

import com.tinnkm.wechat.fileupload.entry.File;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Auther: tinnkm
 * @Date: 2018/11/5 17:42
 * @Description: 文件类
 * @since: 1.0
 */
public interface FileDao extends MongoRepository<File,String> {
    File findByBusinessKey(String businessKey);
}
