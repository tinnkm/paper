package com.tinnkm.wechat.fileupload.service.impl;

import com.tinnkm.wechat.fileupload.dao.TemplateDao;
import com.tinnkm.wechat.fileupload.entry.Template;
import com.tinnkm.wechat.fileupload.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public String save(Template template) {
        return templateDao.save(template).getTemplateId();
    }
}
