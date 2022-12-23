package com.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccessAspect.class);

    //Weaving & Weaver
    @Before("com.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")//pointcut
    public void before(JoinPoint joinPoint) {
        //advice
        LOGGER.info("Check for user");
        LOGGER.info("Allowed Execution for -> {}", joinPoint);
    }

    @AfterReturning(value = "com.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            returning = "result")//pointcut
    public void afterReturning(JoinPoint joinPoint, Object result) {
        //advice
        LOGGER.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(value = "com.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            throwing = "exception")//pointcut
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        //advice
        LOGGER.info("{} throw exception {}", joinPoint, exception);
    }

    @After(value = "com.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")//pointcut
    public void afterThrowing(JoinPoint joinPoint) {
        //advice
        LOGGER.info("after execution of {}", joinPoint);
    }

    @Around("com.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        LOGGER.info("Time taken by {} is {}", joinPoint, timeTaken);
    }
}
