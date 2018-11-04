package com.tinnkm.wechat.fileupload.dao;

import com.tinnkm.wechat.fileupload.entry.Template;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tinnkm
 * @version 1.0
 * @classname TemplateDao
 * @description 模板dao
 * @date 2018/11/4 17:38
 **/
public interface TemplateDao extends JpaRepository<Template,String> {
}
