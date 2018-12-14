package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wycfight.thankspring.modules.sys.bean.SysRoleEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysRoleMapper;
import top.wycfight.thankspring.modules.sys.service.SysRoleService;

/**
 * @author: wycfight@163.com
 * @description: 角色管理
 * @create: 2018-12-14 16:52
 * @modified By:
 **/
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRoleEntity> implements SysRoleService {
}
