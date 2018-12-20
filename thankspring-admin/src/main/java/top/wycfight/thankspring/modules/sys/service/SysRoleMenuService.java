package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.thankspring.modules.sys.bean.SysRoleMenuEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 角色菜单Service
 * @create: 2018-12-19 17:03
 * @modified By:
 **/
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {
    /**
     * 保存角色和菜单之间的关系
     * @param roleId 角色ID
     * @param menuId 菜单ID
     */
    void saveOrUpdate(Long roleId,List<Long> menuId);

    /**
     * 删除角色和菜单之间的关系
     * @param roleIds 角色ID
     */
    int deleteBatch(Long[] roleIds);

    /**
     * 查询角色下所有的菜单列表ID
     * @param roleId 角色ID
     * @return
     */
    List<Long> queryMenuIdListByRoleId(Long roleId);
}
