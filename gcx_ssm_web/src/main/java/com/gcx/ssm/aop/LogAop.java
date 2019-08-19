package com.gcx.ssm.aop;

import com.gcx.ssm.domain.SysLog;
import com.gcx.ssm.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Component
@Aspect
public class LogAop {
    /*
    /**
             * 主键 无意义uuid
             * 访问时间
             * 操作者用户名
             * 访问ip
             * 访问资源url
             * 执行时长
             * 访问方法
    */
    /*
id;
visitTime;
visitTimeStr;
username;
ip;
url;
executionTime;
method;
     */
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    //创建一个环绕通知
    @Around("execution(* com.gcx.ssm.controller.*.*(..))")
    public Object saveLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //访问时间
        Date visitTime = new Date();
        //操作者姓名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //访问时间：开始计时
        long start = System.currentTimeMillis();

        //执行切入点方法
        Object proceed = joinPoint.proceed();

        //获取访问ip
        String ip = request.getRemoteAddr();

        //获取访问url
        String url = request.getRequestURI();

        //访问时间：结束计时
        long end = System.currentTimeMillis();

        //获取方法执行时长
        long executionTime = end - start;

        //获取访问方法
        //获取切入点方法所在类的字节码文件
        String className = joinPoint.getTarget().getClass().getName();
        //获取切入点方法名称
        String methodName = joinPoint.getSignature().getName();
        String method = className + "." + methodName;

        //将以上参数封装到syslog对象中
        SysLog sysLog = new SysLog();
        sysLog.setMethod(method);
        sysLog.setExecutionTime(executionTime);
        sysLog.setUrl(url);
        sysLog.setIp(ip);
        sysLog.setUsername(username);
        sysLog.setVisitTime(visitTime);

        //调用业务层保存
        sysLogService.save(sysLog);
        return proceed;


    }

}
