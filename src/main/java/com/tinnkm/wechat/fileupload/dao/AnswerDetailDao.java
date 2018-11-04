package com.tinnkm.wechat.fileupload.dao;

import com.tinnkm.wechat.fileupload.entry.AnswerDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tinnkm
 * @version 1.0
 * @classname AnswerDetailDao
 * @description 问题详情
 * @date 2018/11/4 18:10
 **/
public interface AnswerDetailDao extends JpaRepository<AnswerDetail,String> {
}
