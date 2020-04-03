package com.lwm.common.exception.file;

import com.lwm.common.exception.BaseException;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:29
 * @Description: 文件信息异常类
 */


public class FileException extends BaseException {
    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}