package com.tinnkm.wechat.fileupload.controller;

import com.tinnkm.wechat.fileupload.entry.Question;
import com.tinnkm.wechat.fileupload.service.QuestionService;
import com.tinnkm.wechat.fileupload.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tinnkm
 * @version 1.0
 * @classname QuestionController
 * @description 问题控制器
 * @date 2018/11/4 17:40
 **/
@RestController
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public Result add(Question question){
        questionService.save(question);
        return Result.success();
    }

    @PostMapping("/addBatch")
    public Result addBatch(List<Question> questions){
        questionService.saveBatch(questions);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Question>> getQuestionList(String templateId){
        List<Question> list = questionService.getList(templateId);
        return Result.success("查询成功",list);
    }
}
