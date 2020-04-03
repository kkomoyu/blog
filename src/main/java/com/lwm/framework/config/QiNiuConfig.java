package com.lwm.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: guya
 * @Date: 2020/3/21 00:50
 * @Description: the setting key and value for file utils
 */
@Data
@Component
@ConfigurationProperties(prefix = "dimple.qiniuyun")
public class QiNiuConfig {
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String path;
    private Long imageMaxSize;
    private Long imageMaxNameLength;
}