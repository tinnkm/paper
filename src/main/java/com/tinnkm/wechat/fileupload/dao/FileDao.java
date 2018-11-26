package com.tinnkm.wechat.fileupload.dao;

import com.tinnkm.wechat.fileupload.entry.File;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Auther: tinnkm
 * @Date: 2018/11/5 17:42
 * @Description: 文件类
 * @since: 1.0
 */
public interface FileDao extends MongoRepository<File,String> {
    List<File> findByBusinessKey(String businessKey);
    List<File> findAllByBusinessKeyIn(List<String> businessKeys);

    /**
     * 可确定唯一时使用
     * @param businessKey
     * @return
     */
    File findOneByBusinessKey(String businessKey);
}
