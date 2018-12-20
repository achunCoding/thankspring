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

    void deleteBatch(Long[] roleIds);
}
