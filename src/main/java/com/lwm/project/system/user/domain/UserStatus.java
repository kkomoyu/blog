package com.lwm.project.system.user.domain;

/**
 * @Auther: guya
 * @Date: 2020/3/20 09:48
 * @Description: 用户状态
 */
public enum UserStatus {
    /**
     * 正常状态
     */
    OK("0", "正常"),
    /**
     * 停用状态
     */
    DISABLE("1", "停用"),
    /**
     * 已删除状态
     */
    DELETED("2", "删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
