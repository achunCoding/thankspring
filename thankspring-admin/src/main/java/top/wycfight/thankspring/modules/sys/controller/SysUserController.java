package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.modules.sys.service.SysUserService;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 用户管理
 * @create: 2018-12-07 14:01
 * @modified By:
 **/
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {

    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public ResultData list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysUserService.queryPage(params);
        return ResultData.ok().put("page",page);

    }

    /**
     * 获取登录的用户信息
     * @return
     */
    @RequestMapping("/info")
    public ResultData info() {
        return ResultData.ok().put("user",getUser());
    }
}
