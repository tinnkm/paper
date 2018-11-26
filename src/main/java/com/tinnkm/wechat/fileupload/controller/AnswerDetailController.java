package com.tinnkm.wechat.fileupload.controller;

import com.tinnkm.wechat.fileupload.service.AnswerDetailService;
import com.tinnkm.wechat.fileupload.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author tinnkm
 * @version 1.0
 * @classname AnswerDetailController
 * @description 问题描述类
 * @date 2018/11/4 18:14
 **/
@RestController
@RequestMapping("/api/answerDetail")
public class AnswerDetailController {
    @Autowired
    private AnswerDetailService answerDetailService;
    @PostMapping("/submit")
    public Result<Boolean> submit(String userId,String templateId){
        try {
            if (answerDetailService.exist(userId, templateId)) {
                Result.error(HttpServletResponse.SC_EXPECTATION_FAILED,"重复提交");
            }
            answerDetailService.save(userId, templateId);
        } catch (Exception e) {
            return Result.error(HttpServletResponse.SC_EXPECTATION_FAILED,e.getMessage());
        }
        return Result.success("提交成功");
    }
}
