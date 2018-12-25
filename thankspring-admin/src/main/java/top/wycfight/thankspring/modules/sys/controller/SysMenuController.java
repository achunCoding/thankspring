package top.wycfight.thankspring.modules.sys.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.exception.GlobalException;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.thankspring.common.annotation.SysLog;
import top.wycfight.thankspring.common.utils.Constant;
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
     *
     * @param sysMenuEntity 菜单实体
     * @return
     */
    @SysLog("保存菜单")
    @RequiresPermissions("sys:menu:save")
    @RequestMapping("/save")
    public ResultData save(@RequestBody SysMenuEntity sysMenuEntity) {
        // 校验数据
        verifyForm(sysMenuEntity);
        sysMenuService.save(sysMenuEntity);
        return ResultData.ok();
    }

    @SysLog("更新菜单")
    @RequiresPermissions("sys:menu:update")
    @RequestMapping("/update")
    public ResultData update(@RequestBody SysMenuEntity sysMenuEntity) {
        // 校验数据
        verifyForm(sysMenuEntity);
        sysMenuService.update(sysMenuEntity);
        return ResultData.ok();
    }

    @SysLog("删除菜单")
    @RequiresPermissions("sys:menu:delete")
    @RequestMapping("/delete")
    public ResultData delete(long menuId) {
        if(menuId < 31) {
            throw new GlobalException("系统菜单，不能删除");
        }
        List<SysMenuEntity> menuEntityList = sysMenuService.queryListParentId(menuId);
        if (menuEntityList.size() > 0) {
            throw new GlobalException("请先删除子菜单或者按钮");
        }
        sysMenuService.delete(menuId);
        return ResultData.ok();
    }



    /**
     * 获取菜单信息
     *
     * @param menuId Menu菜单ID
     * @return
     */
    @RequiresPermissions("sys:menu:info")
    @RequestMapping(value = "/info/{id}")
    public ResultData info(@PathVariable("id") Long menuId) {
        SysMenuEntity sysMenuEntity = sysMenuService.selectById(menuId);
        return ResultData.ok().put("menu", sysMenuEntity);
    }

    /**
     * 验证参数是否正确
     *
     * @param sysMenuEntity 菜单实体
     */
    private void verifyForm(SysMenuEntity sysMenuEntity) {
        if (StringUtils.isBlank(sysMenuEntity.getName())) {
            throw new GlobalException("菜单名称不能为空");
        }

        if (sysMenuEntity.getParentId() == null) {
            throw new GlobalException("上级菜单不能为空");
        }
        //菜单
        if (sysMenuEntity.getType() == Constant.MenuType.MENU.getValue()) {
            if (StringUtils.isBlank(sysMenuEntity.getUrl())) {
                throw new GlobalException("菜单URL不能为空");
            }
        }
        // 上级菜单类型
        int parentType = Constant.MenuType.CATALOG.getValue();
        if (sysMenuEntity.getParentId() != 0) {
            // 查询出上级ID
            SysMenuEntity parentMenu = sysMenuService.selectById(sysMenuEntity.getParentId());
            parentType = parentMenu.getType();
        }

        // 菜单，目录
        if (sysMenuEntity.getType() == Constant.MenuType.CATALOG.getValue() || sysMenuEntity.getType() == Constant.MenuType.MENU.getValue()) {
            if (parentType != Constant.MenuType.CATALOG.getValue()) {
                throw new GlobalException("上级菜单只能为目录类型");
            }
            return;

        }
        // 按钮
        if (sysMenuEntity.getType() == Constant.MenuType.BUTTON.getValue()) {
            if (parentType != Constant.MenuType.MENU.getValue()) {
                throw new GlobalException("上级菜单只能为菜单类型");
            }
            return;
        }

    }


}
