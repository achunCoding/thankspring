package top.wycfight.thankspring.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wycfight@163.com
 * @description: 登录相关
 * @create: 2018-11-29 17:11
 * @modified By:
 **/
@Controller
public class SysLoginController {

    @RequestMapping("hello")
    public String hello() {
        return "index2";
    }
}
