package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description: 用户与角色对应关系
 * @create: 2018-11-15 11:09
 * @modified By:
 **/
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：用户ID
     * @return
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：用户ID
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "SysUserRoleEntity{" +
                "id=" + id +
                ", 用户ID：" + userId +
                ", 角色ID：" + roleId +
                '}';
    }
}
