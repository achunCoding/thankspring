package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.thankspring.modules.sys.bean.SysUserRoleEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysUserRoleMapper;
import top.wycfight.thankspring.modules.sys.service.SysUserRoleService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2018-12-16 20:57
 * @modify By:
 **/
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper,SysUserRoleEntity> implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public List<Long> queryRoleIdList(Long userId) {
        List<Long> roleIdList = sysUserRoleMapper.queryRoleList(userId);
        return roleIdList;
    }
}
