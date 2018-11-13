package cn.itcast.controller;

import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    private Date visitTime;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    @Before("execution(* cn.itcast.controller..*(..))")
    public void doBefore(JoinPoint js) throws NoSuchMethodException {
        visitTime=new Date();



    }

    @After("execution(* cn.itcast.controller..*(..))")
    public void doAfter() throws Exception {

            Date flag = new Date();
            Long executionTime = flag.getTime() - visitTime.getTime();
            String uri = request.getRequestURI();
            StringBuffer requestURL = request.getRequestURL();
            String ip = request.getRemoteAddr();
            SecurityContext context = SecurityContextHolder.getContext();
            User user = (User) context.getAuthentication().getPrincipal();
            String username = user.getUsername();

            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(executionTime.toString());
            sysLog.setIp(ip);
            sysLog.setMethod(uri);
            sysLog.setUrl(requestURL.toString());
            sysLog.setUserName(username);
            sysLog.setVisitTime(visitTime);

            sysLogService.saveSysLog(sysLog);


    }
}
