package com.tinnkm.wechat.fileupload.service.impl;

import com.tinnkm.wechat.fileupload.dao.FileDao;
import com.tinnkm.wechat.fileupload.entry.File;
import com.tinnkm.wechat.fileupload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Auther: tinnkm
 * @Date: 2018/11/5 17:49
 * @Description: 文件服务类实现类
 * @since: 1.0
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;
    @Override
    public File saveFile(File file) {
        return fileDao.save(file);
    }

    @Override
    public void removeFile(String id) {
        fileDao.deleteById(id);
    }

    @Override
    public File getFileByiId(String id) {
        Optional<File> byId = fileDao.findById(id);
        return byId.orElse(null);
    }

    @Override
    public File getBusinessKey(String businessKey) {
        return fileDao.findByBusinessKey(businessKey);
    }
}
