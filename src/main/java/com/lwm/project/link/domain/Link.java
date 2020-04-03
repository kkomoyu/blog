package com.lwm.project.link.domain;

import com.lwm.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/21 09:16
 * @Description:
 */
@Data
public class Link extends BaseEntity {

    private Integer linkId;
    private String title;
    private String description;
    private String headerImg;
    private Integer click;
    private Integer weight;
    private Integer available;
    private Integer processed;
    private Integer display;
    private String email;
    private String url;

}
