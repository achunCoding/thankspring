package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.common.validator.group.UpdateGroup;
import top.wycfight.thankspring.common.annotation.SysLog;
import top.wycfight.thankspring.modules.sys.bean.SysRoleEntity;
import top.wycfight.thankspring.modules.sys.service.SysDeptService;
import top.wycfight.thankspring.modules.sys.service.SysRoleMenuService;
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
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 查询所有角色列表
     *
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
     *
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
     *
     * @param sysRoleEntity 角色实体
     * @return
     */
    @SysLog("保存角色")
    @RequiresPermissions("sys:role:save")
    @RequestMapping("/save")
    public ResultData save(@RequestBody SysRoleEntity sysRoleEntity) {
        ValidatorUtils.validateEntity(sysRoleEntity, AddGroup.class);
        sysRoleService.save(sysRoleEntity);
        return ResultData.ok();
    }

    /**
     * 根据ID查询角色信息
     * @param roleId 角色ID
     * @return
     */
    @RequiresPermissions("sys:role:info")
    @RequestMapping("/info/{roleId}")
    public ResultData info(@PathVariable("roleId") Long roleId) {
        SysRoleEntity sysRoleEntity = sysRoleService.selectById(roleId);
        // 查询出来所有的菜单ID
        List<Long> menuIds = sysRoleMenuService.queryMenuIdListByRoleId(roleId);
        sysRoleEntity.setMenuIdList(menuIds);
        sysRoleEntity.setDeptName(sysDeptService.selectById(sysRoleEntity.getDeptId()).getName());
        // 查询出来所有的部门ID根据角色ID
        return ResultData.ok().put("role", sysRoleEntity);
    }

    /**
     * 更新角色信息
     * @param sysRoleEntity 角色信息
     * @return
     */
    @SysLog("更新角色")
    @RequiresPermissions("sys:role:update")
    @RequestMapping("/update")
    public ResultData update(@RequestBody SysRoleEntity sysRoleEntity) {
        ValidatorUtils.validateEntity(sysRoleEntity, UpdateGroup.class);
        sysRoleService.update(sysRoleEntity);
        return ResultData.ok();
    }

    /**
     * 删除角色信息
     * @param roleIds
     * @return
     */
    @SysLog("删除角色")
    @RequiresPermissions("sys:role:delete")
    @RequestMapping("/delete")
    public ResultData delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);
        return ResultData.ok();

    }

}
