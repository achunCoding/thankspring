package top.wycfight.thankspring.modules.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.wycfight.thankspring.common.exception.MyException;

/**
 * @author: wycfight@163.com
 * @description: 测试Controller
 * @create: 2018-11-19 10:00
 * @modified By:
 **/
@Controller
public class TestController {
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }
}
