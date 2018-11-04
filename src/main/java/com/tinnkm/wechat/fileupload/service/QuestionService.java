package com.tinnkm.wechat.fileupload.service;

import com.tinnkm.wechat.fileupload.entry.Question;

import java.util.List;

/**
 * @author tinnkm
 * @version 1.0
 * @classname QuestionService
 * @description 问题服务层
 * @date 2018/11/4 17:41
 **/
public interface QuestionService {
    void save(Question question);
    void saveBatch(List<Question> questionList);
    List<Question> getList(String templateId);
}
