package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 角色
 * @create: 2018-11-15 10:56
 * @modified By:
 **/
@TableName("sys_role")
public class SysRoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门ID
     */
    @NotNull(message =  "部门不能为空")
    private Long deptId;

    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;

    @TableField(exist = false)
    private List<Long> menuIdList;

    @TableField(exist = false)
    private List<Long> deptIdList;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

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
     * 获取： 角色名称
     * @return
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置：角色名称
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取：备注
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：备注
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：部门ID
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

    /**
     * 获取：部门名称
     * @return
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置：部门名称
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取：菜单ID列表
     * @return
     */
    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    /**
     * 设置：菜单ID列表
     * @param menuIdList
     */
    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    /**
     * 获取：部门ID列表
     * @return
     */
    public List<Long> getDeptIdList() {
        return deptIdList;
    }

    /**
     * 设置：部门ID列表
     * @param deptIdList
     */
    public void setDeptIdList(List<Long> deptIdList) {
        this.deptIdList = deptIdList;
    }

    /**
     * 获取：创建时间
     * @return
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：更新时间
     * @return
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置：更新时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SysRoleEntity{" +
                "角色ID：" + roleId +
                ", 角色名称：" + roleName + '\'' +
                ", 备注：" + remark + '\'' +
                ", 部门ID：" + deptId +
                ", 部门名称：" + deptName + '\'' +
                ", 创建时间：" + createTime +
                ", 更新时间：" + updateTime +
                '}';
    }
}
