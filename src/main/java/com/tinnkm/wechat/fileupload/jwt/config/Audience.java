package com.tinnkm.wechat.fileupload.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tinnkm
 * @version 1.0
 * @classname Audience
 * @description jwt配置类
 * @date 2018/11/4 9:47
 **/
@Data
@ConfigurationProperties(prefix = "spring.jwt.audience")
@Component
public class Audience {
    private String clientId;
    private String secret;
    private String name;
    private Integer expires;
}
