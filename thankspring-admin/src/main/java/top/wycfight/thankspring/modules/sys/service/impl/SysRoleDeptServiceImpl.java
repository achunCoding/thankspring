package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wycfight.common.utils.MapUtils;
import top.wycfight.thankspring.modules.sys.bean.SysRoleDeptEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysRoleDeptMapper;
import top.wycfight.thankspring.modules.sys.service.SysRoleDeptService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 角色部门Service
 * @create: 2019-01-16 15:55
 * @modified By:
 **/
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDeptEntity> implements SysRoleDeptService {
    @Override
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        // 首先删除角色和数据权限之间的关系
        this.deleteByMap(new MapUtils().put("role_id", roleId));

        if (deptIdList == null || deptIdList.size() == 0) {
            return;
        }

        List<SysRoleDeptEntity> sysRoleDeptEntityList = new ArrayList<>(deptIdList.size());

        for (Long deptId : deptIdList) {
            SysRoleDeptEntity sysRoleDeptEntity = new SysRoleDeptEntity();
            sysRoleDeptEntity.setRoleId(roleId);
            sysRoleDeptEntity.setDeptId(deptId);
            sysRoleDeptEntityList.add(sysRoleDeptEntity);
        }

        this.insertBatch(sysRoleDeptEntityList);
    }

    @Override
    public List<Long> queryDeptIdListByRoleId(Long roleId) {
        return baseMapper.queryDeptListByRoleId(roleId);
    }

    @Override
    public void deleteBatch(Long[] roleIds) {
         baseMapper.deleteBatchByRoleIds(roleIds);
    }
}
