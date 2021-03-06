package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.modules.sys.bean.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 系统用户
 * @create: 2018-11-08 20:38
 * @modify By:
 **/
public interface  SysUserService extends IService<SysUserEntity> {
    /**
     * 分页查询所有记录
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询用户下的所有菜单
     * @param userId 用户ID
     * @return
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 保存用户
     * @param user 用户对象
     */
    void save(SysUserEntity user);

    /**
     * 修改用户
     */
    void update(SysUserEntity user);

    /**
     * 修改密码
     * @param userId       用户ID
     * @param password     原密码
     * @param newPassword  新密码
     */
    boolean updatePassword(Long userId, String password, String newPassword);

}
