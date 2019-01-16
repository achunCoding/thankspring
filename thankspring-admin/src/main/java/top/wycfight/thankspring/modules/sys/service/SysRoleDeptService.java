package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.thankspring.modules.sys.bean.SysRoleDeptEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 角色部门Service
 * @create: 2019-01-16 15:46
 * @modified By:
 **/
public interface SysRoleDeptService extends IService<SysRoleDeptEntity> {
    /**
     * 保存和更新角色和部门之间的关系
     * @param roleId 角色ID
     * @param deptIdList 部门ID列表
     */
    void saveOrUpdate(Long roleId, List<Long> deptIdList);

    /**
     * 根据角色Id查询到所有的数据权限列表
     * @param roleId 角色ID
     * @return 数据权限ID列表
     */
    List<Long> queryDeptIdListByRoleId(Long roleId);

    /**
     * 批量角色和部门之间的关系
     * @param roleIds
     */
    void deleteBatch(Long[] roleIds);
}
