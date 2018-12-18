package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wycfight.common.utils.HttpContextUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.modules.sys.sdk.GeetestLib;
import top.wycfight.thankspring.modules.sys.shiro.ShiroUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: wycfight@163.com
 * @description: 登录相关
 * @create: 2018-11-29 17:11
 * @modified By:
 **/
@Controller
public class SysLoginController {
    @Value("${geetest.geetest_id}")
    private String  geetestId;

    @Value("${geetest.geetest_key}")
    private String geetestKey;

    @Value("${geetest.newfailback: false}")
    private boolean newFailBack;


    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param geetestChallenge 验证码
     * @param geetestValidate 验证码
     * @param geetestSeccode 验证码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public ResultData login(String username, String password, String geetestChallenge, String geetestValidate, String  geetestSeccode) {
        int result = verification(geetestChallenge, geetestValidate, geetestSeccode);
        if (result != 1) {
            return ResultData.error("验证失败，请再次尝试");
        }
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultData.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResultData.error("账户或密码不正确");
        } catch (LockedAccountException e) {
            return ResultData.error("账户验证失败，请联系管理员");
        } catch (AuthenticationException e) {
            return ResultData.error("账号验证失败");
        }

        return ResultData.ok();
    }


    /**
     * 退出登陆系统
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }


    /**
     * 极验 验证码校验
     * @param geetestChallenge 验证码 标识符
     * @param geetestValidate 验证码 标识符
     * @param geetestSeccode 验证码 标识符
     * @return
     */
    private int verification(String geetestChallenge, String geetestValidate, String  geetestSeccode) {
        // 验证码 这块实现的很垃 和前台一样拉
        GeetestLib gtSdk = new GeetestLib(geetestId, geetestKey,newFailBack);
        // 获取request对象
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //从session中获取gt-server状态
        int gtServerStatusCode = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
        //从session中获取userid
        String userid = (String)request.getSession().getAttribute("userid");
        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        //网站用户id
        param.put("user_id", userid);
        //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("client_type", "web");
        //传输用户请求验证时所携带的IP
        param.put("ip_address", "127.0.0.1");
        int result = 0;
        if (gtServerStatusCode == 1) {
            //gt-server正常，向gt-server进行二次验证

            result = gtSdk.enhencedValidateRequest(geetestChallenge, geetestValidate, geetestSeccode, param);
            System.out.println(result);
        } else {
            // gt-server非正常情况下，进行failback模式验证
            System.out.println("failback:use your own server captcha validate");
            result = gtSdk.failbackValidateRequest(geetestChallenge, geetestValidate, geetestSeccode);

        }
        return result;
    }

}
