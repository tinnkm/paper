package com.tinnkm.wechat.fileupload.controller;

import com.tinnkm.wechat.fileupload.entry.File;
import com.tinnkm.wechat.fileupload.service.FileService;
import com.tinnkm.wechat.fileupload.utils.MD5Util;
import com.tinnkm.wechat.fileupload.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

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

    @PostMapping("/upload/{businessKey}")
    public Result upload(@RequestParam("file")MultipartFile file,@PathVariable("businessKey") String businessKey,String path) throws IOException {
        File saveFile = new File(file.getName(), file.getContentType(), file.getSize(), MD5Util.getMD5( file.getBytes()), file.getBytes(), businessKey,path);
        fileService.saveFile(saveFile);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id){
        fileService.removeFile(id);
        return Result.success();
    }

    @PostMapping("/answered")
    public Result<Map<String,List<String>>> getByBusinessKey(String userId,String questionIds){
        List<String> list = new ArrayList<>();
        if (questionIds.contains(",")){
            String[] split = questionIds.split(",");
            list.addAll(Arrays.asList(split));
        }else {
            list.add(questionIds);
        }

        Map<String,List<String>> map = fileService.getAnswered(userId,list);
        return Result.success("获取成功",map);
    }

    @GetMapping("/image/{questionId}")
    public void getQuestionImage(@PathVariable String questionId,HttpServletResponse response) {
        File file = fileService.getOneByBusinessKey(questionId);
        if (null != file){
            try(OutputStream stream = response.getOutputStream()) {
                stream.write(file.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
