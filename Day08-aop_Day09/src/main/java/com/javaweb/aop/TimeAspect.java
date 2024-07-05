package com.javaweb.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: gs_wang
 * @Date: 2024/07/04/下午3:09
 * @Description:
 */
@Slf4j
@Component
@Aspect // AOP类
public class TimeAspect {

    @Pointcut("@annotation(com.javaweb.aop.MyLog)")  // 匹配自定义注解
    private void pt(){}

    @Around("execution(* com.javaweb.service.*.*(..))") // 切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        /*
         * 记录开始时间
         * 调用原始方法运行
         * 记录结束时间，计算方法执行耗时
         * */
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法执行耗时：{}ms", end - begin);

        return result;

    }

    @Before("pt()")
    public void before(JoinPoint joinPoint){
        log.info("before");
    }

}
