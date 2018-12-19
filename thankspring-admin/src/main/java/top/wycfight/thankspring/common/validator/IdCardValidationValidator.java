package top.wycfight.thankspring.common.validator;

import top.wycfight.thankspring.common.validator.check.IdCardValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wycfight@163.com
 * @description: 身份证校验
 * @create: 2018-12-19 09:12
 * @modified By:
 **/
public class IdCardValidationValidator implements ConstraintValidator<IdCardValidation,String> {

    private static final Pattern ID_CARD_CHECK = Pattern.compile("^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$");

    @Override
    public void initialize(IdCardValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value == null || value.length() == 0 ) {
            return true;
        }
        Matcher m = ID_CARD_CHECK.matcher(value);
        return m.matches();
    }
}
