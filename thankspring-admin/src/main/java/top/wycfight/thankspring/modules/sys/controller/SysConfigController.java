package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.thankspring.common.annotation.SysLog;
import top.wycfight.thankspring.modules.sys.bean.SysConfigEntity;
import top.wycfight.thankspring.modules.sys.service.SysConfigService;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 系统配置Controller
 * @create: 2019-01-17 12:58
 * @modified By:
 **/
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {

    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 查询系统配置列表
     *
     * @param params 请求参数
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public ResultData list(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils = sysConfigService.queryPage(params);
        return ResultData.ok().put("page", pageUtils);
    }

    /**
     * 保存系统配置
     *
     * @param sysConfigEntity 系统配置实体
     * @return
     */
    @SysLog("保存配置")
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public ResultData save(@RequestBody SysConfigEntity sysConfigEntity) {
        ValidatorUtils.validateEntity(sysConfigEntity);
        sysConfigService.saveSysConfigEntity(sysConfigEntity);
        return ResultData.ok();
    }

    /**
     * 查找系统配置信息
     *
     * @param id 系统配置ID
     * @return
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public ResultData info(@PathVariable("id") Long id) {
        SysConfigEntity sysConfigEntity = sysConfigService.selectById(id);
        return ResultData.ok().put("config", sysConfigEntity);
    }

    /**
     * 更新系统配置
     *
     * @param sysConfigEntity 系统配置
     * @return
     */
    @SysLog("更新配置")
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public ResultData update(@RequestBody SysConfigEntity sysConfigEntity) {
        ValidatorUtils.validateEntity(sysConfigEntity);
        sysConfigService.updateSysConfigEntity(sysConfigEntity);
        return ResultData.ok();
    }

    @SysLog("删除配置")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public ResultData delete(@RequestBody Long[] ids) {
        sysConfigService.deleteSysConfigEntity(Arrays.asList(ids));
        return ResultData.ok();
    }


}
