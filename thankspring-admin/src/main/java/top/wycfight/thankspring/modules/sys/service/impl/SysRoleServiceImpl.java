package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.sys.bean.SysDeptEntity;
import top.wycfight.thankspring.modules.sys.bean.SysRoleEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysRoleMapper;
import top.wycfight.thankspring.modules.sys.service.SysDeptService;
import top.wycfight.thankspring.modules.sys.service.SysRoleMenuService;
import top.wycfight.thankspring.modules.sys.service.SysRoleService;
import top.wycfight.thankspring.modules.sys.service.SysUserRoleService;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 角色管理
 * @create: 2018-12-14 16:52
 * @modified By:
 **/
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRoleEntity> implements SysRoleService {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysUserRoleService sysUserRoleService;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName = (String) params.get("roleName");
        Page<SysRoleEntity> page = this.selectPage(new Query<SysRoleEntity>(params).getPage(),
                new EntityWrapper<SysRoleEntity>().like(StringUtils.isNotBlank(roleName), "roleName", roleName)
                        .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER)));
        // 遍历Page 放入部门ID名称
        for (SysRoleEntity sysRoleEntity : page.getRecords()) {
            SysDeptEntity sysDeptEntity = sysDeptService.selectById(sysRoleEntity.getDeptId());
            if (sysDeptEntity != null) {
                sysRoleEntity.setDeptName(sysDeptEntity.getName());
            }
        }

        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(SysRoleEntity sysRoleEntity) {
        sysRoleEntity.setCreateTime(new Date());
        sysRoleEntity.setUpdateTime(new Date());
        this.insert(sysRoleEntity);
        // 保存role menu 之间的关系
        sysRoleMenuService.saveOrUpdate(sysRoleEntity.getRoleId(), sysRoleEntity.getMenuIdList());
        // 保存role dept之间的关系
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(SysRoleEntity sysRoleEntity) {
        sysRoleEntity.setUpdateTime(new Date());
        //会更新所有的列，没有传值的列会更新为null
        this.updateAllColumnById(sysRoleEntity);
        // 保存role menu 之间的关系
        sysRoleMenuService.saveOrUpdate(sysRoleEntity.getRoleId(), sysRoleEntity.getMenuIdList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatch(Long[] roleIds) {
        // 删除角色信息
        this.deleteBatchIds(Arrays.asList(roleIds));

        // 删除角色和用户之间的关系
        sysUserRoleService.deleteBatch(roleIds);
        // 删除角色和菜单之间的关系
        sysRoleMenuService.deleteBatch(roleIds);
        // TODO 删除角色和部门之间的关系


    }
}
