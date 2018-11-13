package com.tinnkm.wechat.fileupload.service.impl;

import com.tinnkm.wechat.fileupload.dao.QuestionDao;
import com.tinnkm.wechat.fileupload.dao.TemplateDao;
import com.tinnkm.wechat.fileupload.entry.Question;
import com.tinnkm.wechat.fileupload.entry.Template;
import com.tinnkm.wechat.fileupload.service.TemplateService;
import com.tinnkm.wechat.fileupload.vo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author tinnkm
 * @version 1.0
 * @classname TemplateServiceImpl
 * @description 模板实现类
 * @date 2018/11/4 17:36
 **/
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateDao templateDao;
    @Autowired
    private QuestionDao questionDao;

    @Override
    public String save(Template template) {
        return templateDao.save(template).getTemplateId();
    }

    @Override
    public Paper getPaper(String type) {
        Optional<Template> template = templateDao.findById(type);
        List<Question> questionList = questionDao.findAllByTemplateId(type);
        Paper paper = new Paper();
        paper.setTemplate(template.get());
        paper.setQuestions(questionList);
        return paper;
    }
}
