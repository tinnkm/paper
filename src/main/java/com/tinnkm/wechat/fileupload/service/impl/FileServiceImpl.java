package com.tinnkm.wechat.fileupload.service.impl;

import com.tinnkm.wechat.fileupload.dao.FileDao;
import com.tinnkm.wechat.fileupload.entry.File;
import com.tinnkm.wechat.fileupload.service.FileService;
import com.tinnkm.wechat.fileupload.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<File> getBusinessKey(String businessKey) {
        return fileDao.findByBusinessKey(businessKey);
    }

    @Override
    public File getOneByBusinessKey(String businessKey) {
        return fileDao.findOneByBusinessKey(businessKey);
    }

    @Override
    public Map<String, List<String>> getAnswered(String userId, List<String> questionIds) {
        List<String> businessKeys = questionIds.stream().map(questionId -> MD5Util.getMD5(userId + "_" + questionId)).collect(Collectors.toList());
        List<File> fileList = fileDao.findAllByBusinessKeyIn(businessKeys);
        Map<String, List<String>> map = new HashMap<>();
        questionIds.forEach(questionId -> {
            map.put(questionId,fileList.stream().filter(file -> file.getBusinessKey().equals(MD5Util.getMD5(userId + "_" + questionId))).map(File::getUploadPath).collect(Collectors.toList()));
        });
        return map;
    }
}
