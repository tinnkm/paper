package com.tinnkm.wechat.fileupload.service;

/**
 * @author tinnkm
 * @version 1.0
 * @classname AnswerDetailService
 * @description 问题详情
 * @date 2018/11/4 18:11
 **/
public interface AnswerDetailService {
    boolean save(String userId,String templateId);
    boolean exist(String userId,String templateId);
}
