package top.wycfight.thankspring.modules.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.ResultData;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2018-12-07 14:01
 * @modified By:
 **/
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {

    /**
     * 获取登录的用户信息
     * @return
     */
    @RequestMapping("/info")
    public ResultData info() {
        return ResultData.ok().put("user",getUser());
    }
}
