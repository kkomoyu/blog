package com.lwm.common.exception.user;



/**
 * @Auther: guya
 * @Date: 2020/3/19 09:42
 * @Description: 验证码错误异常类
 */
public class CaptchaException extends UserException {
    private static final long serialVersionUID = 1L;

    public CaptchaException() {
        super("user.jcaptcha.error", null);
    }
}