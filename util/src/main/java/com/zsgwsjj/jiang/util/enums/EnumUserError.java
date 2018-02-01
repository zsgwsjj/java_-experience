package com.zsgwsjj.jiang.util.enums;

/**
 * @author : jiang
 * @time : 2018/1/31 09:59
 */
public enum EnumUserError implements IYaoError {

    NO_USER(101, "user not exist!"),
    PASSWORD_ERROR(102, "password error"),
    USERNAME_EXIST(103, " this username exist");
    private Integer code;
    private String reason;

    EnumUserError(Integer code, String reason) {
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
