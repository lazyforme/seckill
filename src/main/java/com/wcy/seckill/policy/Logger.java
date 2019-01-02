package com.wcy.seckill.policy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: global logger
 * @author: wcy
 * @createdTime: 2019-01-02 15:57
 */

@Component
@Aspect
public class Logger {

    public String getMethodName() {
        return "Logger";
    }

    @Pointcut("execution(public * com.wcy.seckill.repository..*.*(..))")
    public void repositoryLogger() {
    }

    @Before("repositoryLogger()")
    public void preRetrieve() {
        System.out.println(getMethodName() + " [Pre]" + new Date());
    }

    @After("repositoryLogger()")
    public void postRetrieve() {
        System.out.println(getMethodName() + " [Post]" + new Date());
    }

}
