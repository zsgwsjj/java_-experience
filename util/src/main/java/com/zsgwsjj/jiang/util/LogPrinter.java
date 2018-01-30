package com.zsgwsjj.jiang.util;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

@Aspect
public class LogPrinter {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogPrinter.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logAbleMapping() {
    }

    @Around(value = "logAbleMapping()&&(args(..,request))", argNames = "joinPoint,request")
    public Object log(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable {
        StringBuilder requestLog = new StringBuilder();
        requestLog = LogUtils.logRequestInfo(request, requestLog);
        LOGGER.info("request:{}", requestLog);
        long startTime = System.currentTimeMillis();
        // 执行被拦截的方法
        Object result = joinPoint.proceed();
        // 正常执行完了，说明请求处理成功，
        StringBuilder responseLog = new StringBuilder();
        responseLog.append("url: ").append(request.getRequestURI()).append("\t");
        responseLog.append("response: ").append(result.toString()).append("\t");
        long endTime = System.currentTimeMillis();
        responseLog.append("cost_time:").append(endTime - startTime).append("ms\n");
        LOGGER.info("{}", responseLog.toString());
        return result;
    }
}
