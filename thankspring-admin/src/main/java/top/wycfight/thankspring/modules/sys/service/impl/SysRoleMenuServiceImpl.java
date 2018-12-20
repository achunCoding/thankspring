package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wycfight.thankspring.modules.sys.bean.SysRoleMenuEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysRoleMenuMapper;
import top.wycfight.thankspring.modules.sys.service.SysRoleMenuService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 角色菜单Service
 * @create: 2018-12-19 17:04
 * @modified By:
 **/
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenuEntity> implements SysRoleMenuService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrUpdate(Long roleId, List<Long> menuId) {
        //  首先清除之间菜单权限配置（更新）
        deleteBatch(new Long[]{roleId});
        // 如果menuId长度为0 则直接退出
        if (menuId.size() == 0) {
            return;
        }
        List<SysRoleMenuEntity> list = new ArrayList<>(menuId.size());
        // 遍历，存放数据
        for (Iterator<Long> it = menuId.iterator();it.hasNext();) {
            SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
            sysRoleMenuEntity.setMenuId(it.next());
            sysRoleMenuEntity.setRoleId(roleId);
            list.add(sysRoleMenuEntity);
        }
        this.insertBatch(list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }

    @Override
    public List<Long> queryMenuIdListByRoleId(Long roleId) {
        return baseMapper.queryMenuIdListByRoleId(roleId);
    }
}
