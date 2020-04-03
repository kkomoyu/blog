package com.lwm.common.exception.user;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:49
 * @Description: 用户密码不正确或不符合规范异常类
 */
public class UserPasswordNotMatchException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}