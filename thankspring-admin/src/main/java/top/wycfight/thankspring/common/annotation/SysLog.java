package top.wycfight.thankspring.common.annotation;

import java.lang.annotation.*;

/**
 * @author: wycfight@163.com
 * @description: 系统日志注解
 * @create: 2018-12-12 08:28
 * @modified By:
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
