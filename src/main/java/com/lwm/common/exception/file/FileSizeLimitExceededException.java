package com.lwm.common.exception.file;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:33
 * @Description: 文件名大小限制异常类
 */
public class FileSizeLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    public FileSizeLimitExceededException(long defaultMaxSize) {
        super("upload.exceed.maxSize", new Object[]{defaultMaxSize});
    }
}