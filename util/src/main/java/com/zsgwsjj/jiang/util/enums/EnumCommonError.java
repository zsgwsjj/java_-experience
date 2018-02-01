package com.zsgwsjj.jiang.util.enums;

/**
 * @author : jiang
 * @time : 2018/1/31 09:59
 */
public enum EnumCommonError implements IYaoError {

    SERVER_ERROR(-1, "unknown server error");

    private Integer code;
    private String reason;

    EnumCommonError(Integer code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    @Override
    public Integer getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMessage() {
        return reason;
    }

}
