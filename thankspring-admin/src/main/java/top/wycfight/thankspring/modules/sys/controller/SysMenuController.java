package top.wycfight.thankspring.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.ResultData;
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







}
