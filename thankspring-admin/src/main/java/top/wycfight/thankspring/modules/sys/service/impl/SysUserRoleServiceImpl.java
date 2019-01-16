package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import top.wycfight.common.utils.MapUtils;
import top.wycfight.thankspring.modules.sys.bean.SysUserRoleEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysUserRoleMapper;
import top.wycfight.thankspring.modules.sys.service.SysUserRoleService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 系统用户角色Service
 * @create: 2018-12-16 20:57
 * @modify By:
 **/
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity> implements SysUserRoleService {
    @Override
    public List<Long> queryRoleIdList(Long userId) {
        List<Long> roleIdList = baseMapper.queryRoleList(userId);
        return roleIdList;
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        // 首先删除用户和角色的关系
        this.deleteByMap(new MapUtils().put("user_id", userId));

        if (roleIdList.size() == 0 || roleIdList == null) {
            return;
        }

        List<SysUserRoleEntity> sysUserRoleEntityList = new ArrayList<>(roleIdList.size());
        for (Long roleId : roleIdList) {
            SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
            sysUserRoleEntity.setRoleId(roleId);
            sysUserRoleEntity.setUserId(userId);
            sysUserRoleEntityList.add(sysUserRoleEntity);
        }
        this.insertBatch(sysUserRoleEntityList);
    }

    @Override
    public int deleteBatchByUserIds(Long[] userIds) {
        return baseMapper.deleteBatchByUserIds(userIds);
    }

}
