package com.tinnkm.wechat.fileupload.service;

import com.tinnkm.wechat.fileupload.entry.File;

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
    File getBusinessKey(String businessKey);
}
