package com.lwm.common.exception.file;

/**
 * @Auther: guya
 * @Date: 2020/3/19 09:32
 * @Description: 文件名称超长限制异常类
 */
public class FileNameLengthLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    public FileNameLengthLimitExceededException(int defaultFileNameLength) {
        super("upload.filename.exceed.length", new Object[]{defaultFileNameLength});
    }
}