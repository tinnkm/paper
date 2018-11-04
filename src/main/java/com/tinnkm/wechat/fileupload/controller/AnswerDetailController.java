package com.tinnkm.wechat.fileupload.controller;

import com.tinnkm.wechat.fileupload.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/submit")
    public Result<Boolean> submit(String userId,String templateId){
        return Result.success("提交成功");
    }
}
