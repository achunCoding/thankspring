package top.wycfight.thankspring.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.modules.sys.bean.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 数据字典Service
 * @create: 2019-01-17 14:50
 * @modified By:
 **/
public interface SysDictService extends IService<SysDictEntity> {

    /**
     * 分页查询字典数据
     * @param params 请求参数
     * @return
     */
    PageUtils queryPage(Map<String,Object> params);

    /**
     * 保存数据字典
     * @param sysDictEntity 数据字典
     */
    void saveSysDictEntity(SysDictEntity sysDictEntity);

    /**
     * 更新数据字典
     * @param sysDictEntity 数据字典
     */
    void updateSysDictEntity(SysDictEntity sysDictEntity);

    /**
     * 删除数据字典
     * @param dictIdList 数据字典ID列表
     */
    void deleteSysDictEntity(List<Long> dictIdList);
}
