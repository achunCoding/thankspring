package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.thankspring.common.annotation.SysLog;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.modules.sys.bean.SysDeptEntity;
import top.wycfight.thankspring.modules.sys.service.SysDeptService;

import java.util.HashMap;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 部门管理
 * @create: 2018-12-18 15:42
 * @modified By:
 **/
@RestController
@RequestMapping("sys/dept")
public class SysDeptController extends AbstractController {

    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 获取部门信息
     *
     * @return
     */
    @RequiresPermissions("sys:dept:list")
    @RequestMapping("/info")
    public ResultData info() {
        Long deptId = sysDeptService.getInfo();
        return ResultData.ok().put("deptId", deptId);
    }

    /**
     * 查询部门列表
     *
     * @return
     */
    @RequiresPermissions("sys:dept:list")
    @RequestMapping("/list")
    public List<SysDeptEntity> list() {
        List<SysDeptEntity> sysDeptEntityList = sysDeptService.queryList(new HashMap<String, Object>());
        return sysDeptEntityList;
    }

    /**
     * 查询部门形成ztree
     *
     * @return
     */
    @RequiresPermissions("sys:dept:select")
    @RequestMapping("/select")
    public ResultData select() {
        List<SysDeptEntity> sysDeptEntityList = sysDeptService.queryList(new HashMap<String, Object>());
        if (Constant.SUPER_ADMIN == 1) {
            SysDeptEntity root = new SysDeptEntity();
            root.setDeptId(0L);
            root.setName("一级部门");
            root.setParentId(-1L);
            root.setOpen(true);
            sysDeptEntityList.add(root);
        }
        return ResultData.ok().put("deptList", sysDeptEntityList);
    }

    /**
     * 保存部门
     *
     * @return
     */
    @SysLog("添加部门")
    @RequiresPermissions("sys:dept:save")
    @RequestMapping("/save")
    public ResultData save(@RequestBody SysDeptEntity sysDeptEntity) {
        ValidatorUtils.validateEntity(sysDeptEntity, AddGroup.class);
        sysDeptService.save(sysDeptEntity);
        return ResultData.ok();
    }

    /**
     * 获取一个部门信息
     */
    @RequiresPermissions("sys:dept:info")
    @RequestMapping(value = "/info/{deptId}")
    public ResultData infoById(@PathVariable("deptId") Long deptId) {
        SysDeptEntity sysDeptEntity = sysDeptService.selectById(deptId);
        return ResultData.ok().put("dept", sysDeptEntity);
    }

    /**
     * 修改部门信息
     *
     * @param sysDeptEntity 部门对象
     * @return
     */
    @SysLog("修改部门")
    @RequiresPermissions("sys:dept:update")
    @RequestMapping("/update")
    public ResultData update(@RequestBody SysDeptEntity sysDeptEntity) {
        sysDeptService.update(sysDeptEntity);
        return ResultData.ok();
    }

    /**
     * 删除部门信息
     */
    @SysLog("删除部门")
    @RequiresPermissions("sys:dept:delete")
    @RequestMapping("/delete")
    public ResultData delete(long deptId) {
        ResultData resultData = sysDeptService.deleteBydeptId(deptId);
        return resultData;
    }


}
