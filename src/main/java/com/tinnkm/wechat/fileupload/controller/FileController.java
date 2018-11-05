package com.tinnkm.wechat.fileupload.controller;

import com.tinnkm.wechat.fileupload.entry.File;
import com.tinnkm.wechat.fileupload.service.FileService;
import com.tinnkm.wechat.fileupload.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: tinnkm
 * @Date: 2018/11/5 18:01
 * @Description: 文件处理
 * @since: 1.0
 */
@RestController
@RequestMapping("/api/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/{id}")
    public Result<File> getFileById(@PathVariable String id){
        File file = fileService.getFileByiId(id);
        if (null == file){
            Result.error(HttpServletResponse.SC_NOT_FOUND,"未找到对应文件");
        }
        return Result.success("获取文件成功！",file);
    }

    public Result upload(@RequestParam("file")MultipartFile file,@PathVariable("businessKey") String businessKey) throws IOException {
//        new File(file.getName(),file.getContentType(),file.getSize(),MD5Util.getMD5(file.getInputStream()),file.getBytes());
        return Result.success();
    }
}
