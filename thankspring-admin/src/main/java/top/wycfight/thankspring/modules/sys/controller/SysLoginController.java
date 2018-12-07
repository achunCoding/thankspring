package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.modules.sys.shiro.ShiroUtils;

/**
 * @author: wycfight@163.com
 * @description: 登录相关
 * @create: 2018-11-29 17:11
 * @modified By:
 **/
@Controller
public class SysLoginController {


    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param captcha  验证码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public ResultData login(String username, String password, String captcha) {
        // TODO 验证码这块还没有做
//        try {
//            Subject subject = ShiroUtils.getSubject();
//            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//            subject.login(token);
//        } catch (UnknownAccountException e) {
//            return ResultData.error(e.getMessage());
//        } catch (IncorrectCredentialsException e) {
//            return ResultData.error("账户或密码不正确");
//        } catch (LockedAccountException e) {
//            return ResultData.error("账户验证失败，请联系管理员");
//        } catch (AuthenticationException e) {
//            return ResultData.error("账号验证失败");
//        }

        return ResultData.ok();
    }



    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect: login.html";
    }


}
