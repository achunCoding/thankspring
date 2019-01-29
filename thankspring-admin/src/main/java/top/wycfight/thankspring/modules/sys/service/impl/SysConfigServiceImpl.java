package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wycfight.common.exception.GlobalException;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.sys.bean.SysConfigEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysConfigMapper;
import top.wycfight.thankspring.modules.sys.redis.SysConfigRedis;
import top.wycfight.thankspring.modules.sys.service.SysConfigService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 系统设置Service
 * @create: 2019-01-17 13:15
 * @modified By:
 **/
@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfigEntity> implements SysConfigService {
    @Autowired
    private SysConfigRedis sysConfigRedis;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String paramKey = (String) params.get("paramKey");
        Page<SysConfigEntity> page = this.selectPage(
                new Query<SysConfigEntity>(params).getPage(),
                new EntityWrapper<SysConfigEntity>().like(StringUtils.isNotBlank(paramKey), "param_key", paramKey)
                        .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER))
        );
        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveSysConfigEntity(SysConfigEntity sysConfigEntity) {
        sysConfigEntity.setCreateDate(new Date());
        sysConfigEntity.setUpdateDate(new Date());
        this.insert(sysConfigEntity);
        sysConfigRedis.saveOrUpdate(sysConfigEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateSysConfigEntity(SysConfigEntity sysConfigEntity) {
        sysConfigEntity.setUpdateDate(new Date());
        this.updateAllColumnById(sysConfigEntity);
        sysConfigRedis.saveOrUpdate(sysConfigEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteSysConfigEntity(List<Long> configIdList) {
        for (Long configId : configIdList) {
            SysConfigEntity sysConfigEntity = this.selectById(configId);
            sysConfigRedis.delete(sysConfigEntity.getParamKey());
        }
        this.deleteBatchIds(configIdList);
    }


    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        String value = getValue(key);
        if (StringUtils.isNotBlank(value)) {
            return new Gson().fromJson(value, clazz);
        }
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new GlobalException("获取参数失败");
        }
    }

    @Override
    public String getValue(String key) {
        SysConfigEntity sysConfigEntity = sysConfigRedis.get(key);
        if (sysConfigEntity == null) {
            sysConfigEntity = baseMapper.queryByKey(key);
            sysConfigRedis.saveOrUpdate(sysConfigEntity);
        }
        return sysConfigEntity == null ? null : sysConfigEntity.getParamValue();

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateValueByKey(String key, String value) {
        baseMapper.updateValueByKey(key,value);
        sysConfigRedis.delete(key);
    }

}
