package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.modules.sys.bean.SysRoleEntity;
import top.wycfight.thankspring.modules.sys.service.SysRoleService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 角色管理
 * @create: 2018-12-14 16:48
 * @modified By:
 **/
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public ResultData list() {
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.selectList(null);
        return ResultData.ok().put("list",sysRoleEntityList);

    }
}
