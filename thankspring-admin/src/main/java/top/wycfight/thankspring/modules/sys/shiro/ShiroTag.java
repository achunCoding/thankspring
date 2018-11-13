package top.wycfight.thankspring.modules.sys.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * @author: wycfight@163.com
 * @description: Shiro权限标签
 * @create: 2018-11-13 16:10
 * @modified By:
 **/
@Component
public class ShiroTag {

    /**
     * 是否拥有该权限
     * @param permission 权限标识
     * @return true：是    false: 否
     */
    public boolean hasPermission(String permission) {
        Subject subject = SecurityUtils.getSubject();
        return subject != null && subject.isPermitted(permission);
    }
}
