package com.lwm.project.log.operlog.mapper;

import com.lwm.project.log.operlog.domain.OperLog;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 08:17
 * @Description:
 */
public interface OperLogMapper {
    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    void insertOperlog(OperLog operLog);

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    List<OperLog> selectOperLogList(OperLog operLog);

    /**
     * 批量删除系统操作日志
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    int deleteOperLogByIds(String[] ids);

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    OperLog selectOperLogById(Long operId);

    /**
     * 清空操作日志
     */
    void cleanOperLog();

    /**
     * 获取dashboard页面展示的操作日志
     *
     * @return 操作日志集合
     */
    List<OperLog> selectOperLogData();
}
