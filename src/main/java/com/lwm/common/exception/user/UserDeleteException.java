package com.lwm.common.exception.user;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:48
 * @Description: 用户账号已被删除
 */
public class UserDeleteException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserDeleteException() {
        super("user.password.delete", null);
    }
}