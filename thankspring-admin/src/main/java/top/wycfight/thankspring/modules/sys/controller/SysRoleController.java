package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.thankspring.modules.sys.bean.SysRoleEntity;
import top.wycfight.thankspring.modules.sys.service.SysRoleService;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有角色列表
     * @return
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public ResultData select() {
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.selectList(null);
        return ResultData.ok().put("list", sysRoleEntityList);
    }

    /**
     * 分页查询角色列表
     * @param params
     * @return
     */
    @RequiresPermissions("sys:role:list")
    @RequestMapping("/list")
    public ResultData list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysRoleService.queryPage(params);
        return ResultData.ok().put("page", page);
    }

    /**
     * 角色保存
     * @param sysRoleEntity
     * @return
     */
    @RequiresPermissions("sys:role:save")
    @RequestMapping("/save")
    public ResultData save(@RequestBody SysRoleEntity sysRoleEntity) {
        ValidatorUtils.validateEntity(sysRoleEntity,AddGroup.class);
        sysRoleService.save(sysRoleEntity);
        return ResultData.ok();

    }
}
