package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.sys.bean.SysRoleEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysRoleMapper;
import top.wycfight.thankspring.modules.sys.service.SysRoleService;

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
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String roleName = (String) params.get("roleName");
        Page<SysRoleEntity> page = this.selectPage(new Query<SysRoleEntity>(params).getPage(),
                new EntityWrapper<SysRoleEntity>().like(StringUtils.isNotBlank(roleName), "roleName", roleName)
                        .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER)));

        return new PageUtils(page);
    }

    @Override
    public void save(SysRoleEntity sysRoleEntity) {
        sysRoleEntity.setCreateTime(new Date());
        sysRoleEntity.setUpdateTime(new Date());
        this.insert(sysRoleEntity);
        // 保存role menu 之间的关系

        // 保存role dept之间的关系
    }
}
