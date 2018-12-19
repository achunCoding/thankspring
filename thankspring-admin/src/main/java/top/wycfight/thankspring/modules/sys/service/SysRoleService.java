package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.modules.sys.bean.SysRoleEntity;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 角色管理
 * @create: 2018-12-14 16:51
 * @modified By:
 **/
public interface SysRoleService extends IService<SysRoleEntity> {
    /**
     * 分页查询所有条件
     * @param params 请求参数
     * @return
     */
    PageUtils queryPage(Map<String,Object> params);

    /**
     * 保存角色信息
     * @param sysRoleEntity
     */
    void save(SysRoleEntity sysRoleEntity);
}
