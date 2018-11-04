package com.tinnkm.wechat.fileupload.utils;

import lombok.Data;

import javax.servlet.http.HttpServletResponse;

/**
 * @author tinnkm
 * @version 1.0
 * @classname Restult
 * @description 返回前端的数据
 * @date 2018/11/4 17:08
 **/
@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    private Result(int code) {
        this.code = code;
    };
    private Result(int code,String message,T data) {
        this.code = code;
        this.data = data;
        this.message = message;
    };

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success(String message,T data){
        return new Result<>(HttpServletResponse.SC_OK, message, data);
    }
    public static <T> Result<T> success(String message){
        return new Result<>(HttpServletResponse.SC_OK, message);
    }
    public static <T> Result<T> success(){
        return new Result<>(HttpServletResponse.SC_OK);
    }

    public static <T> Result<T> error(int code,String message,T data){
        return new Result<>(code, message, data);
    }
    public static <T> Result<T> error(int code, String message){
        return new Result<>(code, message);
    }
}
