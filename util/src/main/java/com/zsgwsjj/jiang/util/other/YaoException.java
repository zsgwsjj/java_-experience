package com.zsgwsjj.jiang.util.other;

import com.zsgwsjj.jiang.util.enums.IYaoError;

/**
 * @author : jiang
 * @time : 2018/1/30 22:41
 */
public class YaoException extends RuntimeException {

    private String errorCode;
    private String extraMessage;

    public YaoException(IYaoError error) {
        super("error code: " + error.getErrorCode() + ",error desc: " + error.getErrorMessage());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public YaoException setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public YaoException setExtraMessage(String extraMessage) {
        this.extraMessage = extraMessage;
        return this;
    }
}

