package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.wycfight.thankspring.modules.sys.bean.SysUserEntity;

/**
 * @author: wycfight@163.com
 * @description: Controller公共组件
 * @create: 2018-11-09 13:10
 * @modified By:
 **/
public abstract class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取用户使用shiro工具类
     * principals：
     * 身份，即主体的标识属性，可以是任何东西，如用户名、邮箱等，唯一即可。
     * 一个主体可以有多个principals， 但只有一个Primary principals，一般是用户名/密码/手机号。
     * @return 系统用户对象
     */
    protected SysUserEntity getUser() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取用户ID
     * @return 系统用户ID
     */
    protected Long getUserId() {
        return getUser().getUserId();
    }

    /**
     * 获取部门ID
     * @return 部门ID
     */
    protected Long getDeptId() {
        return getUser().getDeptId();
    }


}
