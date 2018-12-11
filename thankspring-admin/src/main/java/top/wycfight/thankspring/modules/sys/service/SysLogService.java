package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.modules.sys.bean.SysLogEntity;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 系统日志
 * @create: 2018-12-11 14:48
 * @modified By:
 **/
public interface SysLogService extends IService<SysLogEntity> {
    PageUtils queryPage(Map<String,Object> params);
}
