package com.zsgwsjj.jiang.util.other;

import com.zsgwsjj.jiang.util.enums.IYaoError;

/**
 * @author : jiang
 * @time : 2018/1/30 22:41
 */
public class YaoException extends RuntimeException {

    private IYaoError errorCode;
    private String extraMessage;

    public YaoException(String message) {
        super(message);
    }

    public YaoException(IYaoError error) {
        super("error code: " + error.getErrorCode() + ",error desc: " + error.getErrorMessage());
        this.errorCode = error;
    }

    public IYaoError getErrorCode() {
        return errorCode;
    }

    public YaoException setErrorCode(IYaoError errorCode) {
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

