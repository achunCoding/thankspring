package top.wycfight.thankspring.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import top.wycfight.thankspring.modules.sys.bean.SysRoleDeptEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 角色部门Mapper
 * @create: 2019-01-16 15:56
 * @modified By:
 **/
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDeptEntity> {
    /**
     *  查询角色下所有的数据权限ID列表
     * @param roleId 角色ID
     * @return 数据权限ID列表
     */
    List<Long> queryDeptListByRoleId(Long roleId);

    /**
     *  删除角色下所有的数据权限ID列表
     * @param roleIds
     */
    void deleteBatchByRoleIds(Long[] roleIds);
}
