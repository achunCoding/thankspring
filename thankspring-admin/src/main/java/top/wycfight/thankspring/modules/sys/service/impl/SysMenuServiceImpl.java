package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.modules.sys.bean.SysMenuEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysMenuMapper;
import top.wycfight.thankspring.modules.sys.service.SysMenuService;
import top.wycfight.thankspring.modules.sys.service.SysUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 系统菜单Service
 * @create: 2018-12-07 13:36
 * @modified By:
 **/
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<SysMenuEntity> getUserMenuList(Long userId) {
        // 系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            return getAllMenuList(null);
        }
        //  用户菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    @Override
    public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenuEntity> menuList = queryListParentId(parentId);
        if (menuIdList == null) {
            return menuList;
        }
        List<SysMenuEntity> userMenuList = new ArrayList<>();
        for (SysMenuEntity sysMenuEntity : userMenuList) {
            if (menuIdList.contains(sysMenuEntity.getMenuId())) {
                userMenuList.add(sysMenuEntity);
            }

        }
        return userMenuList;
    }

    @Override
    public List<SysMenuEntity> queryListParentId(Long parentId) {
        return baseMapper.queryListParentId(parentId);
    }

    @Override
    public List<SysMenuEntity> queryNotButtonList() {
        return baseMapper.queryNotButtonList();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(SysMenuEntity sysMenuEntity) {
        this.insert(sysMenuEntity);
    }


    private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList) {
        // 查询根菜单列表
        List<SysMenuEntity> menuList = queryListParentId(0L, menuIdList);
        // 递归获取子菜单
        getMenuTreeList(menuList,menuIdList);
        return menuList;
    }

    /**
     * 递归
     */
    private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList) {
        List<SysMenuEntity> subMenuList = new ArrayList<>();

        for (SysMenuEntity sysMenuEntity : menuList) {
            if (sysMenuEntity.getType() == Constant.MenuType.CATALOG.getValue()) {
                sysMenuEntity.setList(getMenuTreeList(queryListParentId(sysMenuEntity.getMenuId(), menuIdList), menuIdList));
            }
            subMenuList.add(sysMenuEntity);
        }
        return subMenuList;
    }
}
