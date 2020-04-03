package com.lwm.project.system.notice.service;

import com.lwm.project.system.notice.domain.Notice;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 09:39
 * @Description:
 */
public interface INoticeService {
    /**
     * 查询公告信息
     *
     * @param noticeId 公告ID
     * @return 公告信息
     */
    Notice selectNoticeById(Long noticeId);

    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    int insertNotice(Notice notice);

    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    int updateNotice(Notice notice);

    /**
     * 删除公告信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteNoticeByIds(String ids);

    /**
     * 切换公告显示
     *
     * @param display
     * @param id      需要切换的id
     * @return 受影响的行数
     */
    int changeNoticeDisplayById(Integer display, Integer id);

    /**
     * 获取显示的Notice
     *
     * @return notic集合
     */
    List<Notice> selectNoticeListDisplay();
}

