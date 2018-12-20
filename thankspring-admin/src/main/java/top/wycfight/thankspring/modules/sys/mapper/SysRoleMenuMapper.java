package top.wycfight.thankspring.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import top.wycfight.thankspring.modules.sys.bean.SysRoleMenuEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 角色菜单Mapper
 * @create: 2018-12-19 17:04
 * @modified By:
 **/
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {
    /**
     * 删除角色和权限之间的关系
     * @param roleIds 角色Id
     */
    int deleteBatch(Long[] roleIds);

    /**
     * 查询角色下所有菜单ID列表
     * @param roleId 角色ID
     * @return
     */
    List<Long> queryMenuIdListByRoleId(Long roleId);
}
