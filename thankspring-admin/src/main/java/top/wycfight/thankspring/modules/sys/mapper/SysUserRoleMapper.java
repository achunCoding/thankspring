package top.wycfight.thankspring.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import top.wycfight.thankspring.modules.sys.bean.SysUserRoleEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 用户-角色Mapper
 * @create: 2018-12-16 20:58
 * @modify By:
 **/
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {
    /**
     * 根据用户ID查询角色ID列表
     * @param userId 用户ID
     * @return
     */
    List<Long> queryRoleList(Long userId);

    /**
     * 根据角色ID数组，批量删除
     * @param roleIds 角色ID
     * @return
     */
    int deleteBatch(Long[] roleIds);

    /**
     * 根据用户ID数组，批量删除
     * @param userIds
     * @return
     */
    int deleteBatchByUserIds(Long[] userIds);
}
