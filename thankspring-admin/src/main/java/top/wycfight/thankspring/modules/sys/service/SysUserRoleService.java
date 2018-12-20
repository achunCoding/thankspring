package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.thankspring.modules.sys.bean.SysUserRoleEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 用户-角色Service
 * @create: 2018-12-16 20:56
 * @modify By:
 **/
public interface SysUserRoleService extends IService<SysUserRoleEntity> {
    /**
     * 根据用户Id查询角色Id列表
     * @param userId 用户ID
     * @return
     */
    List<Long>  queryRoleIdList(Long userId);

    /**
     * 通过角色ID 删除与用户对应的关系
     * @param roleIds
     */
    void deleteBatch(Long[] roleIds);
}
