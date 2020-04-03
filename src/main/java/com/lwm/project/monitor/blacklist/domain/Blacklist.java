package com.lwm.project.monitor.blacklist.domain;

import com.lwm.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: guya
 * @Date: 2020/3/21 20:22
 * @Description: 黑名单
 */
@Data
public class Blacklist extends BaseEntity {
    private Integer blacklistId;
    private String ipAddr;
    private String description;
    private Integer count;
    private Date lastAccessTime;
    private String lastAccessUrl;
}