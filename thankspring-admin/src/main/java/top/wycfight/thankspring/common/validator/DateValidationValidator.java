package top.wycfight.thankspring.common.validator;

import top.wycfight.thankspring.common.validator.check.DateValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wycfight@163.com
 * @description: 日期校验
 * @create: 2018-12-19 09:09
 * @modified By:
 **/
public class DateValidationValidator implements ConstraintValidator<DateValidation, String> {
    private static final Pattern DATE_CHECK = Pattern.compile("((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$))");
    private static final Pattern TIME_CHECK = Pattern.compile("^([0-1]?[0-9]|2[0-3]):([0-5][0-9])");
    private static final Pattern YYYYMMHHDDMI = Pattern.compile("^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01]) (0\\d{1}|1\\d{1}|2[0-3]):([0-5]\\d{1})$");

    private String type;

    @Override
    public void initialize(DateValidation constraintAnnotation) {
        this.type = constraintAnnotation.type();


    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean result = false;
        if (value == null || value.length() == 0) {
            return true;
        }
        if ("YYYY-MM-DD".equals(this.type)) {
            Matcher m = DATE_CHECK.matcher(value);
            result = m.matches();
        }
        if ("HH:MM".equals(this.type)) {
            Matcher m = DATE_CHECK.matcher(value);
            result = m.matches();
        }
        if ("YYYY-MM-DD HH:MM".equals(this.type)) {
            Matcher m = DATE_CHECK.matcher(value);
            result = m.matches();
        }
        return result;
    }
}
