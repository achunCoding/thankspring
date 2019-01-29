package top.wycfight.thankspring.modules.oss.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.oss.bean.SysOssEntity;
import top.wycfight.thankspring.modules.oss.mapper.SysOssMapper;
import top.wycfight.thankspring.modules.oss.service.SysOssService;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 文件上传Service
 * @create: 2019-01-21 09:32
 * @modified By:
 **/
@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssMapper,SysOssEntity> implements SysOssService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysOssEntity> sysOssEntityPage = this.selectPage(new Query<SysOssEntity>(params).getPage());
        return new PageUtils(sysOssEntityPage);

    }
}
