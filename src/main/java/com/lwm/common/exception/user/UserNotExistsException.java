package com.lwm.common.exception.user;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:48
 * @Description: 用户不存在异常类
 */
public class UserNotExistsException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}