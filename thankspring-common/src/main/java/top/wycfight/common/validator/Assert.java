package top.wycfight.common.validator;

import org.apache.commons.lang.StringUtils;
import top.wycfight.common.exception.GlobalException;

/**
 * @author: wycfight@163.com
 * @description: 数据校验
 * @create: 2018-11-13 13:38
 * @modified By:
 **/
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new GlobalException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new GlobalException(message);
        }
    }
}
