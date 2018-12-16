package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.sys.bean.SysMenuEntity;
import top.wycfight.thankspring.modules.sys.bean.SysUserEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysMenuMapper;
import top.wycfight.thankspring.modules.sys.mapper.SysUserMapper;
import top.wycfight.thankspring.modules.sys.service.SysMenuService;
import top.wycfight.thankspring.modules.sys.service.SysUserService;
import top.wycfight.thankspring.modules.sys.shiro.ShiroUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 系统菜单Service
 * @create: 2018-12-07 13:36
 * @modified By:
 **/
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUserEntity> implements SysUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String username = (String)params.get("username");

        Page<SysUserEntity> page = this.selectPage(
                new Query<SysUserEntity>(params).getPage(),
                new EntityWrapper<SysUserEntity>()
                        .like(StringUtils.isNotBlank(username),"username", username)
                        .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );

        return new PageUtils(page);

    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserEntity user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        user.setPassword(ShiroUtils.sha256(user.getPassword(),user.getSalt()));
        this.insert(user);
        //TODO 保存用户和角色之间的关系


    }

    @Override
    public void update(SysUserEntity user) {

    }

    @Override
    public boolean updatePassword(Long userId, String password, String newPassword) {
        return false;
    }
}
