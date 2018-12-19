package top.wycfight.thankspring.common.validator;

import top.wycfight.thankspring.common.validator.check.PhoneValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wycfight@163.com
 * @description: 手机号校验器
 * @create: 2018-12-19 09:03
 * @modified By:
 **/
public class PhoneValidationValidator implements ConstraintValidator<PhoneValidation,String> {

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$"
    );
    @Override
    public void initialize(PhoneValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value == null || value.length() == 0 ) {
            return true;
        }
        Matcher m = PHONE_PATTERN.matcher(value);
        return m.matches();
    }
}
