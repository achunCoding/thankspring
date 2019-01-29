package top.wycfight.thankspring.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.wycfight.thankspring.modules.sys.bean.SysConfigEntity;

/**
 * @author: wycfight@163.com
 * @description: 系统配置Mapper
 * @create: 2019-01-17 13:16
 * @modified By:
 **/
public interface SysConfigMapper extends BaseMapper<SysConfigEntity> {
    /**
     * 通过key 查询到系统配置
     * @param key
     * @return
     */
    SysConfigEntity queryByKey(String key);

    /**
     * 通过 key 去更新vlue
     * @param paramKey 键
     * @param paramValue 值
     */
    void updateValueByKey(@Param("paramKey") String paramKey, @Param("paramValue") String paramValue);
}
