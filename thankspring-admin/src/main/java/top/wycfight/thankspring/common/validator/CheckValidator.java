package top.wycfight.thankspring.common.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.wycfight.thankspring.common.validator.check.DateValidation;

import top.wycfight.thankspring.common.validator.check.IdCardValidation;
import top.wycfight.thankspring.common.validator.check.PhoneValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.regex.Pattern;


/**
 * @author: wycfight@163.com
 * @description: 拓展Validator
 * @create: 2018-12-18 13:26
 * @modified By:
 **/
public class CheckValidator implements ConstraintValidator<Annotation, Object> {
    // TODO 这里可以加入Service 操作

    private static final Logger logger = LoggerFactory.getLogger(CheckValidator.class);
    /**
     * 日期检查
     */
    private static final String DATE_CHECK = "((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$))";
    private static final String TIME_CHECK = "^([0-1]?[0-9]|2[0-3]):([0-5][0-9])";
    private static final String YYYYMMHHDDMI = "^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01]) (0\\d{1}|1\\d{1}|2[0-3]):([0-5]\\d{1})$";
    private static final String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    private String value;
    private int annotationType;

    /**
     * 初始化校验器
     *
     * @param annotation
     */
    @Override
    public void initialize(Annotation annotation) {
        if (annotation instanceof DateValidation) {
            annotationType = 0;
            DateValidation dateCheck = (DateValidation) annotation;
            this.value = dateCheck.type();
        }
        if (annotation instanceof IdCardValidation) {
            annotationType = 1;
            IdCardValidation idCardCheck = (IdCardValidation) annotation;
        }
        if (annotation instanceof PhoneValidation) {
            annotationType = 2;
            PhoneValidation moblieCheck = (PhoneValidation) annotation;
        }

    }

    /**
     * 校验的逻辑
     *
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean re = false;
        try {
            switch (annotationType) {
                case 0: {
                    try {
                        if ("YYYY-MM-DD".equals(this.value)) {
                            re = Pattern.matches(DATE_CHECK, (String) value);
                        }
                        if ("HH:MI".equals(this.value)) {
                            re = Pattern.matches(TIME_CHECK, (String) value);
                        }
                        if ("YYYY-MM-DD HH:MI".equals(this.value)) {
                            re = Pattern.matches(YYYYMMHHDDMI, (String) value);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 1: {
                    break;
                }
                case 2: {
                    re = Pattern.matches(PHONE_NUMBER_REG, (String) value);
                    break;
                }
                default:
                    break;
            }
        } catch (Exception e) {
            logger.info("校验异常:" + e.getMessage(), e);
        }
        return re;
    }
}
