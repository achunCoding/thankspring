package top.wycfight.thankspring.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.common.utils.Constant;
import top.wycfight.thankspring.modules.sys.bean.SysDeptEntity;
import top.wycfight.thankspring.modules.sys.mapper.SysDeptMapper;
import top.wycfight.thankspring.modules.sys.service.SysDeptService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static top.wycfight.thankspring.modules.sys.shiro.ShiroUtils.getUserId;

/**
 * @author: wycfight@163.com
 * @description: 系统部门Service
 * @create: 2018-12-18 15:51
 * @modified By:
 **/
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptEntity> implements SysDeptService {
    @Override
    public Long getInfo() {
        long deptId = 0;
        if (Constant.SUPER_ADMIN != getUserId()) {
            List<SysDeptEntity> deptList = this.queryList(new HashMap<String, Object>());
            Long parentId = null;
            if (deptList.size() > 0) {
                for (SysDeptEntity sysDeptEntity : deptList) {
                    parentId = sysDeptEntity.getParentId();
                    if (parentId < sysDeptEntity.getParentId()) {
                        parentId = sysDeptEntity.getParentId();
                    }
                }
            }
            deptId = parentId;
        }
        return deptId;
    }

    @Override
    public List<SysDeptEntity> queryList(Map<String, Object> params) {
        List<SysDeptEntity> sysDeptEntityList = this.selectList(new EntityWrapper<SysDeptEntity>()
                .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER)));
        for (SysDeptEntity sysDeptEntity : sysDeptEntityList) {
            SysDeptEntity parentSysDeptEntity = this.selectById(sysDeptEntity.getParentId());
            if (parentSysDeptEntity != null) {
                sysDeptEntity.setParentName(parentSysDeptEntity.getName());
            }
        }
        return sysDeptEntityList;

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(SysDeptEntity sysDeptEntity) {
        sysDeptEntity.setCreateTime(new Date());
        sysDeptEntity.setUpdateTime(new Date());
        this.insert(sysDeptEntity);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(SysDeptEntity sysDeptEntity) {
        sysDeptEntity.setUpdateTime(new Date());
        this.updateById(sysDeptEntity);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData deleteBydeptId(Long deptId) {
        List<Long> list = this.queryDeptIdList(deptId);
        if (list.size() > 0) {
            return ResultData.error("请先删除子部门");
        }
        this.deleteById(deptId);
        return ResultData.ok();
    }

    @Override
    public List<Long> queryDeptIdList(Long deptId) {
        return baseMapper.queryDeptIdList(deptId);
    }


}
