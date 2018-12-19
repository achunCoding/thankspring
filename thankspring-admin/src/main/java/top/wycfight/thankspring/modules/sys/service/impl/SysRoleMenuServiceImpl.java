package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wycfight.thankspring.modules.sys.bean.SysRoleMenuEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysRoleMenuMapper;
import top.wycfight.thankspring.modules.sys.service.SysRoleMenuService;

/**
 * @author: wycfight@163.com
 * @description: 角色菜单Service
 * @create: 2018-12-19 17:04
 * @modified By:
 **/
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper,SysRoleMenuEntity> implements SysRoleMenuService {

    @Override
    public void saveOrUpdate(Long roleId, Long[] menuId) {
        // 首先清除之间菜单权限配置

    }
}
