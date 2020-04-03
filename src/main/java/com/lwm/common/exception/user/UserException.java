package com.lwm.common.exception.user;

import com.lwm.common.exception.BaseException;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:44
 * @Description: 用户信息异常类
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }

}