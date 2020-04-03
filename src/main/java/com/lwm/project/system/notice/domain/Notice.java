package com.lwm.project.system.notice.domain;

import com.lwm.framework.web.domain.BaseEntity;
import lombok.Data;

/**
 * @Auther: guya
 * @Date: 2020/3/21 09:33
 * @Description: 通知公告表 sys_notice
 */
@Data
public class Notice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     */
    private Integer noticeId;
    /**
     * 公告标题
     */
    private String noticeTitle;
    /**
     * 显示（0不显示 1显示）
     */
    private Integer display;

}
