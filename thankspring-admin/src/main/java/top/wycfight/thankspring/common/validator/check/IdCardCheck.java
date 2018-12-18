package top.wycfight.thankspring.common.validator.check;

import top.wycfight.thankspring.common.validator.CheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author: wycfight@163.com
 * @description: 身份证校验
 * @create: 2018-12-18 13:46
 * @modified By:
 **/
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckValidator.class)
@Documented
public @interface IdCardCheck {
    //默认错误消息
    String message() default "Identity card format error";
    //查询的表名
    //分组
    Class<?>[] groups() default { };

    //负载
    Class<? extends Payload>[] payload() default { };

    //指定多个时使用
    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        IdCardCheck[] value();
    }

}
