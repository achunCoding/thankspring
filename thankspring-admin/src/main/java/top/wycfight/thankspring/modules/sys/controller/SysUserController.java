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
import top.wycfight.thankspring.modules.sys.bean.SysUserEntity;
import org.apache.commons.lang.ArrayUtils;
import top.wycfight.thankspring.modules.sys.service.SysUserRoleService;
import top.wycfight.thankspring.modules.sys.service.SysUserService;

import java.util.Arrays;
import java.util.List;
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

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 查询用户列表
     *
     * @param params 请求参数
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public ResultData list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysUserService.queryPage(params);
        return ResultData.ok().put("page", page);

    }

    @SysLog("保存用户")
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public ResultData save(@RequestBody SysUserEntity sysUserEntity) {
        ValidatorUtils.validateEntity(sysUserEntity,AddGroup.class);
        sysUserService.save(sysUserEntity);
        return ResultData.ok();
    }

    @SysLog("更新用户")
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public ResultData update(@RequestBody SysUserEntity sysUserEntity) {
        ValidatorUtils.validateEntity(sysUserEntity,UpdateGroup.class);
        sysUserService.update(sysUserEntity);
        return ResultData.ok();
    }

    @SysLog("删除用户")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public ResultData delete(@RequestBody Long[] userIds) {
        if(ArrayUtils.contains(userIds, 1L)){
            return ResultData.error("系统管理员不能删除");
        }

        if(ArrayUtils.contains(userIds, getUserId())){
            return ResultData.error("当前用户不能删除");
        }

        sysUserService.deleteBatchIds(Arrays.asList(userIds));
        return ResultData.ok();
    }

    /**
     * 根据用户Id查询用户信息
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public ResultData getUserInfo(@PathVariable("userId")Long userId) {
        SysUserEntity sysUserEntity = sysUserService.selectById(userId);
        // 查询到用户下的角色信息
        List<Long> roleIdList =  sysUserRoleService.queryRoleIdList(userId);
        sysUserEntity.setRoleIdList(roleIdList);
        return ResultData.ok().put("user",sysUserEntity);
    }
    /**
     * 获取登录的用户信息
     *
     * @return
     */
    @RequestMapping("/info")
    public ResultData info() {
        return ResultData.ok().put("user", getUser());
    }
}
