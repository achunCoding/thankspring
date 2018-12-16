package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description: 角色和菜单对应关系
 * @create: 2018-11-15 11:17
 * @modified By:
 **/
@TableName("sys_role_menu")
public class SysRoleMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     *菜单ID
     */
    private Long menuId;

    /**
     * 设置：ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 获取：ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：角色ID
     * @return
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置：角色ID
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取：菜单ID
     * @return
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置：菜单ID
     * @param menuId
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "SysRoleMenuEntity{" +
                "id=" + id +
                ", 角色ID：" + roleId +
                ", 菜单ID" + menuId +
                '}';
    }
}
