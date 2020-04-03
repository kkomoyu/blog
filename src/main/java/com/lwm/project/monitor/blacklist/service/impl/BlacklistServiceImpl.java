package com.lwm.project.monitor.blacklist.service.impl;

import com.lwm.common.constant.BlacklistConstants;
import com.lwm.common.utils.security.ShiroUtils;
import com.lwm.project.monitor.blacklist.domain.Blacklist;
import com.lwm.project.monitor.blacklist.mapper.BlacklistMapper;
import com.lwm.project.monitor.blacklist.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: guya
 * @Date: 2020/3/21 20:24
 * @Description:
 */
@Service
public class BlacklistServiceImpl implements BlacklistService {
    @Autowired
    BlacklistMapper blacklistMapper;

    @Override
    public List<Blacklist> selectBlacklistList(Blacklist blacklist) {
        return blacklistMapper.selectBlacklistList(blacklist);
    }

    @Override
    public int deleteBlacklistByIds(Integer[] ids) {
        return blacklistMapper.deleteBlacklistByBlacklistIds(ids);
    }

    @Override
    public Blacklist selectBlacklistById(Integer blacklistId) {
        return blacklistMapper.selectBlacklistById(blacklistId);
    }

    @Override
    public void cleanBlacklist() {
        blacklistMapper.cleanBlacklist();
    }

    @Override
    public int insertBlacklist(Blacklist blacklist) {
        blacklist.setCreateBy(ShiroUtils.getLoginName());
        return blacklistMapper.insertBlacklist(blacklist);
    }

    @Override
    public void updateNewestBlacklist(Integer id, String requestURI) {
        blacklistMapper.updateNewestBlacklist(id, requestURI);
    }

    @Override
    public boolean checkIpIsInBlacklist(String ip) {
        Blacklist blacklist = blacklistMapper.selectBlacklistByIp(ip);
        return blacklist == null ? BlacklistConstants.IP_NOT_IN_BLACKLIST : BlacklistConstants.IP_IN_BLACKLIST;
    }

    @Override
    public Blacklist selectBlacklistByIp(String ip) {
        return blacklistMapper.selectBlacklistByIp(ip);
    }

    @Override
    public int insertBlacklist(String ipAddr) {
        Blacklist blacklist = new Blacklist();
        blacklist.setIpAddr(ipAddr);
        return blacklistMapper.insertBlacklist(blacklist);
    }

    @Override
    public int updateBlacklist(Blacklist blacklist) {
        return blacklistMapper.updateBlacklist(blacklist);
    }
}