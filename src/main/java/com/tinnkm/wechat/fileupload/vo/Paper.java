package com.tinnkm.wechat.fileupload.vo;

import com.tinnkm.wechat.fileupload.entry.Question;
import com.tinnkm.wechat.fileupload.entry.Template;
import lombok.Data;

import java.util.List;

/**
 * @Auther: tinnkm
 * @Date: 2018/11/13 16:52
 * @Description: 试题封装类
 * @since: 1.0
 */
@Data
public class Paper {
    private Template template;
    private List<Question> questions;
}
