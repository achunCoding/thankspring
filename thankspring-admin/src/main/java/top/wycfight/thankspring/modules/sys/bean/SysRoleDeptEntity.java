package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-01-16 15:49
 * @modified By:
 **/
@TableName("sys_role_dept")
public class SysRoleDeptEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 角色部门ID
     */
    @TableId
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 获取：角色部门ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置： 角色部门ID
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
     * 获取: 部门ID
     * @return
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置：部门ID
     * @param deptId
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "SysRoleDeptEntity{" +
                "id=" + id +
                ", 角色ID=" + roleId +
                ", 部门ID=" + deptId +
                '}';
    }
}
