package top.wycfight.thankspring.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import top.wycfight.thankspring.modules.sys.bean.SysDeptEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 系统部门Mapper
 * @create: 2018-12-18 15:53
 * @modified By:
 **/
public interface SysDeptMapper extends BaseMapper<SysDeptEntity> {
    List<Long> queryDeptIdList(Long deptId);
}
