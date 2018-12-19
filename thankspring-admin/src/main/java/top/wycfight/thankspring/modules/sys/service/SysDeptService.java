package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.modules.sys.bean.SysDeptEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 部门Service
 * @create: 2018-12-18 15:45
 * @modified By:
 **/
public interface SysDeptService extends IService<SysDeptEntity> {
    /**
     * 获取部门信息
     * @return
     */
    Long getInfo();

    /**
     * 获取部门信息列表
     * @return
     */
    List<SysDeptEntity> queryList(Map<String,Object> params);

    /**
     * 保存部门信息
     * @param sysDeptEntity 部门信息
     */
    void save(SysDeptEntity sysDeptEntity);

    /**
     * 修改部门信息
     * @param sysDeptEntity 部门信息
     */
    void update(SysDeptEntity sysDeptEntity);

    /**
     * 删除部门信息(需要先查询是否有子部门)
     * @param deptId 部门ID
     */
    ResultData deleteBydeptId(Long deptId);

    /**
     * 查询下是否有子部门
     * @param deptId 部门ID
     * @return
     */
    List<Long> queryDeptIdList(Long deptId);
}
