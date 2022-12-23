package com.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.spring.aop.springaop.business.*.*(..))")
    public void businessLayerExecution() {
    }

    @Pointcut("execution(* com.spring.aop.springaop.business.*.*(..)) && execution(* com.spring.aop.springaop.dao.*.*(..))")
    public void allLayerExecution() {
    }

    @Pointcut("bean(dao*)")
    public void beanStartingWithDao() {
    }

    @Pointcut("bean(*dao*)")
    public void beanContainingWithDao() {
    }

    @Pointcut("within(com.spring.aop.springaop.dao..*)")
    public void daoLayerExecutionWithin() {
    }

    @Pointcut("@annotation(com.spring.aop.springaop.aspect.TrackTime)")
    public void trackTimeAnnotation() {
    }
}
