package com.javaweb.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: gs_wang
 * @Date: 2024/07/04/下午4:07
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME) // 运行时读取
@Target(ElementType.METHOD) // 作用在方法上
public @interface MyLog {
}
