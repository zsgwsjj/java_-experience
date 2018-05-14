package com.zsgwsjj.jiang.util.other;


import com.zsgwsjj.jiang.util.enums.EnumCommonError;
import com.zsgwsjj.jiang.util.util.LogUtils;
import com.zsgwsjj.jiang.util.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiang
 * @desc 统一异常处理
 */
@ControllerAdvice(annotations = org.springframework.stereotype.Controller.class)
public class ExHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private String exceptionHandler(Exception e, HttpServletRequest request) {
        String result;
        if (e instanceof YaoException) {
            YaoException errorException = (YaoException) e;
            if (errorException.getErrorCode().getErrorCode().equals(EnumCommonError.SERVER_ERROR.getErrorCode())) {
                LOGGER.error("error:", e);
            }
            result = ResponseUtil.geneCommonResponse(errorException);
        }
        else if (e instanceof MissingServletRequestParameterException) {
            LOGGER.warn("missed params :{}", e.getMessage());
            result = ResponseUtil.geneCommonResponse(EnumCommonError.SERVER_ERROR);
        } else if (e instanceof TypeMismatchException) {
            LOGGER.warn("param type mismatch :{}", e.getMessage());
            result = ResponseUtil.geneCommonResponse(EnumCommonError.SERVER_ERROR);
        } else {
            LOGGER.error("exception", e);
            result = ResponseUtil.geneCommonResponse(EnumCommonError.SERVER_ERROR);
        }
        StringBuilder log = new StringBuilder();
        log = LogUtils.logRequestInfo(request, log);
        log.append("response:").append(result).append("\t\n");
        LOGGER.info(log.toString());
        return result;
    }
}

