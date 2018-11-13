package com.tinnkm.wechat.fileupload.service.impl;

import com.tinnkm.wechat.fileupload.dao.QuestionDao;
import com.tinnkm.wechat.fileupload.entry.Question;
import com.tinnkm.wechat.fileupload.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tinnkm
 * @version 1.0
 * @classname QuestionServiceImpl
 * @description 问题类具体实现
 * @date 2018/11/4 17:57
 **/
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Override
    public void save(Question question) {
        questionDao.save(question);
    }

    @Override
    public void saveBatch(List<Question> questionList) {
        questionDao.saveAll(questionList);
    }

    @Override
    public List<Question> getList(String templateId) {
        return questionDao.findAllByTemplateId(templateId);
    }
}
