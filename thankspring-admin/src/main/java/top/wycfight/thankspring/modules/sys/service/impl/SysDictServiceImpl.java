package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.sys.bean.SysDictEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysDictMapper;
import top.wycfight.thankspring.modules.sys.service.SysDictService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 数据字典Service
 * @create: 2019-01-17 14:51
 * @modified By:
 **/
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictEntity> implements SysDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        Page<SysDictEntity> page = this.selectPage(new Query<SysDictEntity>(params).getPage(),
                new EntityWrapper<SysDictEntity>().like(StringUtils.isNotBlank(name), "name", name)
                        .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER))
        );
        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveSysDictEntity(SysDictEntity sysDictEntity) {
        sysDictEntity.setCreateDate(new Date());
        sysDictEntity.setUpdateDate(new Date());
        this.insert(sysDictEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateSysDictEntity(SysDictEntity sysDictEntity) {
        sysDictEntity.setUpdateDate(new Date());
        this.updateById(sysDictEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteSysDictEntity(List<Long> dictIdList) {
        this.deleteBatchIds(dictIdList);
    }


}
