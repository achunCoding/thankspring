package top.wycfight.thankspring.modules.sys.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import top.wycfight.common.exception.GlobalException;
import top.wycfight.thankspring.modules.sys.bean.SysUserEntity;

/**
 * @author: wycfight@163.com
 * @description: Shirl工具类
 * @create: 2018-11-13 15:41
 * @modified By:
 **/
public class ShiroUtils {
    /**  加密算法 */
    public final static String hashAlgorithmName = "SHA-256";
    /**  循环次数 */
    public final static int hashIterations = 16;

    /**
     * 安全散列算法  SHA-256
     * @param password 密码
     * @param salt 盐
     * @return 加密生成的字符串
     */
    public static String sha256(String password, String salt) {
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }

    /**
     * 获取Session
     * Session机制是一种服务器端的机制，服务器使用一种类似于散列表的结构（也可能就是使用散列表）来保存信息。
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
     * @return Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取系统用户对象
     * @return 系统用户对象
     */
    public static SysUserEntity getUserEntity() {
        return (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取用户ID
     * @return 用户ID
     */
    public static Long getUserId() {
        return getUserEntity().getUserId();
    }

    /**
     * 将以key存在的value存放在session中
     * @param key key(键)
     * @param value value(值)
     */
    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 根据key获取session中存放的值
     * @param key key(键)
     * @return value（值）
     */
    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 验证是否正常登录
     * @return true: 已登录   false：未登录
     */
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    /**
     * 退出系统
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 生成验证码
     * @param key
     * @return
     */
    public static String getKaptcha(String key) {
        Object kaptcha = getSessionAttribute(key);
        if(kaptcha == null){
            throw new GlobalException("验证码已失效");
        }
        getSession().removeAttribute(key);
        return kaptcha.toString();
    }
}
