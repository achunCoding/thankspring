package top.wycfight.thankspring.modules.sys.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wycfight.thankspring.common.config.GeetestConfig01;
import top.wycfight.thankspring.common.config.GeetestConfig02;
import top.wycfight.thankspring.modules.sys.sdk.GeetestLib;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: wycfight@163.com
 * @description: 系统页面视图
 * @create: 2018-11-15 15:02
 * @modified By:
 **/
@Controller
public class SysPageController {

    @Value("${geetest.geetest_id}")
    private String  geetestId;

    @Value("${geetest.geetest_key}")
    private String geetestKey;

    @Value("${geetest.newfailback: false}")
    private boolean newFailBack;

    @RequestMapping("modules/{module}/{url}.html")
    public String module(@PathVariable("module") String module, @PathVariable("url") String url) {
        return "modules/" + module + "/" + url;
    }
    @RequestMapping(value = {"/", "index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping("index1.html")
    public String index1(){
        return "index1";
    }

    @RequestMapping("login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("main.html")
    public String main(){
        return "main";
    }

    /**
     * 生成滑动验证码1
     */
    @RequestMapping("gt/register")
    @ResponseBody
    public String generateCode(HttpServletRequest request) {
        GeetestLib gtSdk = new GeetestLib(geetestId, geetestKey,
                newFailBack);

        String resStr = "{}";

        String userid = "test";

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        //网站用户id
        param.put("user_id", userid);
        //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("client_type", "web");
        //传输用户请求验证时所携带的IP
        param.put("ip_address", "127.0.0.1");

        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(param);

        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("userid", userid);

        resStr = gtSdk.getResponseStr();
        return resStr;
    }




}
