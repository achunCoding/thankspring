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
 * @description: 手机号校验
 * @create: 2018-12-18 13:48
 * @modified By:
 **/
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckValidator.class)
@Documented
public @interface MobileCheck {
    String message() default "Malformed phone number";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    //指定多个时使用
}
