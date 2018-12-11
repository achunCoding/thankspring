package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.modules.sys.service.SysLogService;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 系统日志
 * @create: 2018-12-11 15:08
 * @modified By:
 **/
@RestController
@RequestMapping("/sys/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;


    @RequestMapping("/list")
    @RequiresPermissions("sys:log:list")
    public ResultData list(@RequestParam Map<String,Object> params) {
        PageUtils page = null;
        return null;

    }

}
