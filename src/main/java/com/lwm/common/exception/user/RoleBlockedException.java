package com.lwm.common.exception.user;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:46
 * @Description: 角色锁定异常类
 */
public class RoleBlockedException extends UserException {
    private static final long serialVersionUID = 1L;

    public RoleBlockedException() {
        super("role.blocked", null);
    }

}