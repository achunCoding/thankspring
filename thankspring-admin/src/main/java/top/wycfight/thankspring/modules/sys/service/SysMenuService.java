package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.thankspring.modules.sys.bean.SysMenuEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 系统菜单Service
 * @create: 2018-12-07 13:18
 * @modified By:
 **/
public interface SysMenuService extends IService<SysMenuEntity> {
    /**
     * 获取用户菜单列表
     * @param userId 用户ID
     * @return 用户菜单列表
     */
    List<SysMenuEntity> getUserMenuList(Long userId);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList 用户菜单ID
     * @return 用户菜单列表
     */
    List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 根据父菜单，获取子菜单
     * @param parentId 父菜单ID
     * @return 用户菜单列表
     */
    List<SysMenuEntity> queryListParentId(Long parentId);




}
