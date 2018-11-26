package com.tinnkm.wechat.fileupload.service.impl;

import com.tinnkm.wechat.fileupload.dao.AnswerDetailDao;
import com.tinnkm.wechat.fileupload.dao.QuestionDao;
import com.tinnkm.wechat.fileupload.entry.AnswerDetail;
import com.tinnkm.wechat.fileupload.entry.File;
import com.tinnkm.wechat.fileupload.entry.Question;
import com.tinnkm.wechat.fileupload.service.AnswerDetailService;
import com.tinnkm.wechat.fileupload.service.FileService;
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
    @Autowired
    private FileService fileService;
    @Autowired
    private AnswerDetailDao answerDetailDao;

    @Override
    public boolean exist(String userId, String templateId) {
        return false;
    }

    @Override
    public boolean save(String userId, String templateId) {
        List<Question> questions = questionDao.findAllByTemplateId(templateId);
        questions.forEach(question -> {
            // 查询mongodb
            List<File> files = fileService.getBusinessKey(MD5Util.getMD5(userId + "_" + question.getQuestionId()));
            files.forEach(file -> {
                AnswerDetail answerDetail = new AnswerDetail();
                answerDetail.setTemplateId(templateId);
                answerDetail.setQuestionId(question.getQuestionId());
                answerDetail.setUserId(userId);
                if (question.isRequired() && null == file){
                    throw new IllegalStateException("有必答题未答");
                }
                if (null == file) {
                    answerDetail.setAnswered(false);
                } else {
                    if (null == file.getContent()) {
                        answerDetail.setHasAttachment(false);
                    } else {
                        answerDetail.setHasAttachment(true);
                        answerDetail.setAttachmentPath("/api/file/" + file.getId());
                    }
                    answerDetail.setAnswered(true);
                }
                answerDetailDao.save(answerDetail);
            });
        });
        return true;
    }
}
