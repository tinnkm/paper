package com.tinnkm.wechat.fileupload.service.impl;

import com.tinnkm.wechat.fileupload.dao.QuestionDao;
import com.tinnkm.wechat.fileupload.entry.Question;
import com.tinnkm.wechat.fileupload.service.AnswerDetailService;
import com.tinnkm.wechat.fileupload.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tinnkm
 * @version 1.0
 * @classname AnswerDetailServiceImpl
 * @description 答案实现类
 * @date 2018/11/4 18:12
 **/
@Service
public class AnswerDetailServiceImpl implements AnswerDetailService {
    @Autowired
    private QuestionDao questionDao;
    @Override
    public boolean save(String userId, String templateId) {
        List<Question> questions = questionDao.findAllByTemplateId(templateId);
        List<String> bussinessKeyList = questions.stream().map(question -> MD5Util.getMD5(userId + "_" + question.getQuestionId())).collect(Collectors.toList());
        return false;
    }
}
