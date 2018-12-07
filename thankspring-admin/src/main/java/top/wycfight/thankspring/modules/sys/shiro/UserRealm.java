package top.wycfight.thankspring.modules.sys.shiro;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.modules.sys.bean.SysMenuEntity;
import top.wycfight.thankspring.modules.sys.bean.SysUserEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysMenuMapper;
import top.wycfight.thankspring.modules.sys.mapper.SysUserMapper;

import java.util.*;

/**
 * @author: wycfight@163.com
 * @description: 认证
 * @create: 2018-11-15 13:24
 * @modified By:
 **/
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 授权(验证权限时调用)
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUserEntity user = (SysUserEntity) principalCollection.getPrimaryPrincipal();
        Long userId = user.getUserId();
        List<String> permsList;
        // 系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            List<SysMenuEntity> menuEntityList = sysMenuMapper.selectList(null);
            permsList = new ArrayList<>(menuEntityList.size());
            for (SysMenuEntity sysMenuEntity: menuEntityList) {
                permsList.add(sysMenuEntity.getPerms());
            }
        } else {
            permsList = sysUserMapper.queryAllPerms(userId);
        }

        // 用户权限列表
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证（login）
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // 查询用户信息
        SysUserEntity user = new SysUserEntity();
        user.setUsername(user.getUsername());
        user = sysUserMapper.selectOne(user);
        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        // 账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定，请联系管理员");
        }
        /* 第一个参数 user 第二个从数据库中获取的password 第三个realm */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return info;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
