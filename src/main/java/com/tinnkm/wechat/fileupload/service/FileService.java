package com.tinnkm.wechat.fileupload.service;

import com.tinnkm.wechat.fileupload.entry.File;

import java.util.List;
import java.util.Map;

/**
 * @Auther: tinnkm
 * @Date: 2018/11/5 17:44
 * @Description: 文件服务类
 * @since: 1.0
 */
public interface FileService {
    /**
     * 保存文件
     * @param file 文件实体
     * @return
     */
    File saveFile(File file);

    /**
     * 删除文件
     * @param id 文件id
     */
    void removeFile(String id);

    /**
     * 获取文件
     * @param id 文件id
     * @return
     */
    File getFileByiId(String id);

    /**
     * 根据业务主键获取文件
     * @param businessKey 业务主键
     * @return 文件
     */
    List<File> getBusinessKey(String businessKey);

    /**
     * 根据业务主键获取文件
     * @param businessKey 业务主键
     * @return 文件
     */
    File getOneByBusinessKey(String businessKey);

    /**
     * 获取用户存入的数据
     * @param userId 用户id
     * @param questionIds 问题id集合
     * @return 返回路径
     */
    Map<String, List<String>> getAnswered(String userId, List<String> questionIds);
}
