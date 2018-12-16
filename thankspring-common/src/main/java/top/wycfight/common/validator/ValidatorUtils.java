package top.wycfight.common.validator;

import top.wycfight.common.exception.GlobalException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author: wycfight@163.com
 * @description: hibernate-validator校验工具类
 *
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 * @create: 2018-11-13 13:40
 * @modified By:
 **/
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws GlobalException  校验不通过，则报RRException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws GlobalException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = (ConstraintViolation<Object>)constraintViolations.iterator().next();
            throw new GlobalException(constraint.getMessage());
        }
    }
}
