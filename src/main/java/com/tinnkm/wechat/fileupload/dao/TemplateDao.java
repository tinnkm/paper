package com.tinnkm.wechat.fileupload.dao;

import com.tinnkm.wechat.fileupload.entry.Template;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: tinnkm
 * @Date: 2018/11/13 17:21
 * @Description: 模版dao
 * @since: 1.0
 */
public interface TemplateDao extends JpaRepository<Template,String> {
}
