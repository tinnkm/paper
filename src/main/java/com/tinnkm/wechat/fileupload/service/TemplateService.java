package com.tinnkm.wechat.fileupload.service;

import com.tinnkm.wechat.fileupload.entry.Template;
import com.tinnkm.wechat.fileupload.vo.Paper;

/**
 * @author tinnkm
 * @version 1.0
 * @classname TemplateService
 * @description 模板创建类
 * @date 2018/11/4 17:34
 **/
public interface TemplateService {
    String save(Template template);

    /**
     * 根据type获取试卷
     * @param type 类型
     * @return 试卷封装类
     */
    Paper getPaper(String type);
}
