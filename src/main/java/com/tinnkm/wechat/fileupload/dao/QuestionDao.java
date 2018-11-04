package com.tinnkm.wechat.fileupload.dao;

import com.tinnkm.wechat.fileupload.entry.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author tinnkm
 * @version 1.0
 * @classname QuestionDao
 * @description 问题dao
 * @date 2018/11/4 17:40
 **/
public interface QuestionDao extends JpaRepository<Question,String> {
    List<Question> findAllByTemplateId(String templateId);
}
