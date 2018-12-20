package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.thankspring.common.annotation.SysLog;
import top.wycfight.thankspring.modules.sys.bean.SysMenuEntity;
import top.wycfight.thankspring.modules.sys.service.SysMenuService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 系统菜单
 * @create: 2018-12-07 13:17
 * @modified By:
 **/
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 导航菜单
     */
    @RequestMapping("/navigation")
    public ResultData navigation() {
        List<SysMenuEntity> menuList = sysMenuService.getUserMenuList(getUserId());
        return ResultData.ok().put("menuList", menuList);
    }

    /**
     * 查询菜单列表
     *
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<SysMenuEntity> list() {
        List<SysMenuEntity> menuEntityList = sysMenuService.selectList(null);
        for (SysMenuEntity sysMenuEntity : menuEntityList) {
            SysMenuEntity parentSysMenuEntity = sysMenuService.selectById(sysMenuEntity.getParentId());
            if (parentSysMenuEntity != null) {
                sysMenuEntity.setParentName(parentSysMenuEntity.getName());
            }
        }
        return menuEntityList;
    }

    /**
     * 查询菜单列表
     *
     * @return
     */
    @RequiresPermissions("sys:menu:select")
    @RequestMapping("/select")
    public ResultData select() {
        List<SysMenuEntity> menuEntityList = sysMenuService.queryNotButtonList();
        // 设置一级菜单
        SysMenuEntity sysMenuEntity = new SysMenuEntity();
        sysMenuEntity.setOpen(true);
        sysMenuEntity.setMenuId(0L);
        sysMenuEntity.setParentId(-1L);
        sysMenuEntity.setName("一级菜单");
        menuEntityList.add(sysMenuEntity);
        return ResultData.ok().put("menuList", menuEntityList);
    }

    /**
     * 保存菜单
     * @param sysMenuEntity 菜单实体
     * @return
     */
    @SysLog("保存菜单")
    @RequiresPermissions("sys:menu:save")
    @RequestMapping("/save")
    public ResultData save(@RequestBody SysMenuEntity sysMenuEntity) {
        ValidatorUtils.validateEntity(sysMenuEntity,AddGroup.class);
        sysMenuService.save(sysMenuEntity);
        return ResultData.ok();
    }


}
