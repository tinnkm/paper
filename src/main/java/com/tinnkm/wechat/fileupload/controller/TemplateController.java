package com.tinnkm.wechat.fileupload.controller;

import com.tinnkm.wechat.fileupload.entry.Template;
import com.tinnkm.wechat.fileupload.service.TemplateService;
import com.tinnkm.wechat.fileupload.utils.Result;
import com.tinnkm.wechat.fileupload.vo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tinnkm
 * @version 1.0
 * @classname TemplateController
 * @description 模板相关controller
 * @date 2018/11/4 17:31
 **/
@RestController
@RequestMapping("/api/template")
public class TemplateController {
    private final TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping("/create")
    public Result<String> create(Template template){
        String templateId = templateService.save(template);
        return Result.success("模板创建成功",templateId);
    }

    @GetMapping("/{type}")
    public Result<Paper> getPaper(@PathVariable String type){
        Paper paper = templateService.getPaper(type);
        return Result.success("获取模版成功",paper);
    }
}
