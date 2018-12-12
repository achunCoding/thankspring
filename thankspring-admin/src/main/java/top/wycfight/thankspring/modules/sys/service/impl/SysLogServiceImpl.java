package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.sys.bean.SysLogEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysLogMapper;
import top.wycfight.thankspring.modules.sys.service.SysLogService;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 系统日志
 * @create: 2018-12-11 14:53
 * @modified By:
 **/
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper,SysLogEntity> implements SysLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String)params.get("key");
        Page<SysLogEntity> page = this.selectPage(
                new Query<SysLogEntity>(params).getPage(),
                new EntityWrapper<SysLogEntity>().like(StringUtils.isNotBlank(key),"username", key)
        );

        return new PageUtils(page);
    }
}
