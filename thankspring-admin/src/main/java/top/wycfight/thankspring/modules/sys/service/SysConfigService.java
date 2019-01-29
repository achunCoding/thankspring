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
    public PageUtils queryPage(Map<String,Object> params);

    /**
     * 保存系统配置
     * @param sysConfigEntity 系统配置实体
     */
    public void saveSysConfigEntity(SysConfigEntity sysConfigEntity);

    /**
     * 更新系统配置
     * @param sysConfigEntity 系统配置实体
     */
    public void updateSysConfigEntity(SysConfigEntity sysConfigEntity);

    /**
     * 删除系统配置
     * @param configIdList 系统配置ID
     */
    public void deleteSysConfigEntity(List<Long> configIdList);

    /**
     * 根据key， 获取value的Object对象
     * @param key key
     * @param clazz Object对象
     * @param <T>
     * @return
     */
    public <T> T getConfigObject(String key, Class<T> clazz);

    /**
     * 根据key，获取配置的value值
     * @param key key
     * @return
     */
    public String getValue(String key);


    /**
     * 通过Key更新值
     * @param key
     * @param json
     */
    public void updateValueByKey(String key, String json);


}
