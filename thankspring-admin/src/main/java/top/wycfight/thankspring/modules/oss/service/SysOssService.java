package top.wycfight.thankspring.modules.oss.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.modules.oss.bean.SysOssEntity;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 文件上传（OSS）Service
 * @create: 2019-01-21 09:31
 * @modified By:
 **/
public interface SysOssService extends IService<SysOssEntity> {

    /**
     * 分页查询
     * @param params 分页参数
     * @return
     */
    public PageUtils queryPage(Map<String,Object> params);
}
