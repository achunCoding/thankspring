package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.thankspring.common.annotation.SysLog;
import top.wycfight.thankspring.modules.sys.bean.SysDictEntity;
import top.wycfight.thankspring.modules.sys.service.SysDictService;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 字典数据Controller
 * @create: 2019-01-17 14:46
 * @modified By:
 **/
@RestController
@RequestMapping("/sys/dict")
public class SysDictController extends AbstractController {

    @Autowired
    private SysDictService sysDictService;

    /**
     * 查询数据字典列表
     *
     * @param params 请求参数
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:dict:list")
    public ResultData list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysDictService.queryPage(params);
        return ResultData.ok().put("page", page);
    }

    /**
     * 保存数据字典列表
     *
     * @param sysDictEntity 数据字典
     * @return
     */
    @SysLog("保存字典")
    @RequestMapping("/save")
    @RequiresPermissions("sys:dict:save")
    public ResultData save(@RequestBody SysDictEntity sysDictEntity) {
        ValidatorUtils.validateEntity(sysDictEntity);
        sysDictService.saveSysDictEntity(sysDictEntity);
        return ResultData.ok();
    }

    /**
     * 查询用户信息
     *
     * @return
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:dict:info")
    public ResultData info(@PathVariable("id") Long id) {
        SysDictEntity sysDictEntity = sysDictService.selectById(id);
        return ResultData.ok().put("dict", sysDictEntity);
    }

    /**
     * 更新字典数据
     *
     * @param sysDictEntity 字典数据
     * @return
     */
    @SysLog("更新字典")
    @RequestMapping("/update")
    @RequiresPermissions("sys:dict:update")
    public ResultData update(@RequestBody SysDictEntity sysDictEntity) {
        ValidatorUtils.validateEntity(sysDictEntity);
        sysDictService.updateSysDictEntity(sysDictEntity);
        return ResultData.ok();
    }

    /**
     * 删除字典数据
     *
     * @param dictIds 字典数据IDs
     * @return
     */
    @SysLog("删除字典")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dict:delete")
    public ResultData delete(@RequestBody Long[] dictIds) {
        sysDictService.deleteSysDictEntity(Arrays.asList(dictIds));
        return ResultData.ok();
    }


}
