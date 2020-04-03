package com.lwm.common.exception.user;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:51
 * @Description: 用户错误最大次数异常类
 */
public class UserPasswordRetryLimitExceedException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
    }
}