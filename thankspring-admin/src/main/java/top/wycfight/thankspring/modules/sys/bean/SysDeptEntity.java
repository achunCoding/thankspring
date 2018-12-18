package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 系统部门
 * @create: 2018-12-18 15:29
 * @modified By:
 **/
@TableName("sys_dept")
public class SysDeptEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 部门ID */
    @TableId
    private Long deptId;
    /** 上级部门ID，一级部门为0 */
    private Long parentId;
    /** 部门名称 */
    private String name;
    @TableField(exist = false)
    private String parentName;
    /** 排序 */
    private Integer orderNum;

    /** 是否删除 */
    @TableLogic
    private Integer delFlag;
    /**
     * ztree属性
     */
    @TableField(exist=false)
    private Boolean open;
    @TableField(exist=false)
    private List<?> list;

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
     * 获取：父类部门ID  一级部门为0
     * @return
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置：父类部门ID 一级部门为0
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：部门名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：部门名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：父类部门名称
     * @return
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 设置：父类部门名称
     * @param parentName
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * 获取：排序
     * @return
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置：排序
     * @param orderNum
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取：是否删除
     * @return
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置：是否删除
     * @param delFlag
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取：ztree属性
     * @return
     */
    public Boolean getOpen() {
        return open;
    }

    /**
     * 设置：ztree属性
     * @param open
     */
    public void setOpen(Boolean open) {
        this.open = open;
    }

    /**
     * 获取：ztree属性
     * @return
     */
    public List<?> getList() {
        return list;
    }

    /**
     * 设置：ztree属性
     * @param list
     */
    public void setList(List<?> list) {
        this.list = list;
    }
}
