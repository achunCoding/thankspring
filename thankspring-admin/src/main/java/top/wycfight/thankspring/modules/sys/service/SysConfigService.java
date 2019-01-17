package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.modules.sys.bean.SysConfigEntity;
import top.wycfight.thankspring.modules.sys.bean.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 系统设置Service
 * @create: 2019-01-17 13:14
 * @modified By:
 **/
public interface SysConfigService extends IService<SysConfigEntity> {
    /**
     * 分页查询系统配置参数
     * @param params 请求的所有参数信息
     * @return
     */
    PageUtils queryPage(Map<String,Object> params);

    /**
     * 保存系统配置
     * @param sysConfigEntity 系统配置实体
     */
    void saveSysConfigEntity(SysConfigEntity sysConfigEntity);

    /**
     * 更新系统配置
     * @param sysConfigEntity 系统配置实体
     */
    void updateSysConfigEntity(SysConfigEntity sysConfigEntity);

    /**
     * 删除系统配置
     * @param configIdList 系统配置ID
     */
    void deleteSysConfigEntity(List<Long> configIdList);
}
