package top.wycfight.thankspring.modules.sys.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.wycfight.common.utils.RedisUtils;
import top.wycfight.thankspring.common.utils.RedisKeys;
import top.wycfight.thankspring.modules.sys.bean.SysConfigEntity;

/**
 * @author: wycfight@163.com
 * @description: 系统配置Redis
 * @create: 2019-01-21 13:32
 * @modified By:
 **/
@Component
public class SysConfigRedis {

    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfigEntity config) {
        if (config == null) {
            return;
        }
        String key = RedisKeys.getSysConfigKey(config.getParamKey());
        redisUtils.set(key,config);
    }


    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }


    public SysConfigEntity get(String configKey) {
        String sysConfigKey = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(sysConfigKey, SysConfigEntity.class);
    }



}
