package top.wycfight.thankspring.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import top.wycfight.thankspring.modules.sys.bean.SysMenuEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 菜单管理
 * @create: 2018-11-15 13:22
 * @modified By:
 **/
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     * @param parentId
     * @return
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    List<SysMenuEntity> queryNotButtonList();
}
