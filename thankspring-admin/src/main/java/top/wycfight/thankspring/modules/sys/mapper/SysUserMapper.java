package top.wycfight.thankspring.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import top.wycfight.thankspring.modules.sys.bean.SysUserEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 系统用户
 * @create: 2018-11-13 16:15
 * @modified By:
 **/
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    /**
     * 查询用户的所有权限
     * @param userId 用户ID
     * @return
     */
    List<String>  queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     * @param userId 用户ID
     * @return
     */
    List<Long> queryAllMenuId(Long userId);
}
