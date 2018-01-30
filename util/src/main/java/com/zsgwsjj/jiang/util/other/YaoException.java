package com.zsgwsjj.jiang.util.other;

/**
 * @author : jiang
 * @time : 2018/1/30 22:41
 */
public class YaoException extends RuntimeException {

    private String errorCode;
    private String extraMessage;

    public YaoException(String errorCode, String extraMessage) {
        super("error code: " + errorCode + ",error desc: " + extraMessage);
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

