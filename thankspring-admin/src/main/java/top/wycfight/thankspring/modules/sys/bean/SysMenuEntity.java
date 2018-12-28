package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 菜单管理
 * @create: 2018-11-15 11:12
 * @modified By:
 **/
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId
    private Long menuId;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 父菜单名称
     */
    @TableField(exist=false)
    private String parentName;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权（多个用逗号隔开，如user:list,user:create)
     */
    private String perms;

    /**
     * 类型     0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * ztree属性
     */
    @TableField(exist=false)
    private Boolean open;

    @TableField(exist=false)
    private List<?> list;

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

    /**
     * 获取：父菜单ID
     * @return
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置：父菜单ID
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：父菜单名称
     * @return
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 设置：父菜单名称
     * @param parentName
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * 获取：菜单名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：菜单名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：菜单URL
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置：菜单URL
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：菜单权限
     * @return
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置：菜单权限
     * @param perms
     */
    public void setPerms(String perms) {
        this.perms = perms;
    }

    /**
     * 获取：菜单类型
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置：菜单类型
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：菜单图标
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置：菜单图标
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取：菜单排序
     * @return
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置：菜单排序
     * @param orderNum
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取：ztree属性
     * @return
     */
    public Boolean getOpen() {
        return open;
    }

    /**
     * 设置： ztree属性
     * @param open
     */
    public void setOpen(Boolean open) {
        this.open = open;
    }

    /**
     * 获取： ztree属性
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

    @Override
    public String toString() {
        return "SysMenuEntity{" +
                "菜单ID：" + menuId +
                ",父菜单ID：" + parentId +
                ", 父菜单名称：" + parentName + '\'' +
                ", 菜单名称：" + name + '\'' +
                ", 菜单URL：" + url + '\'' +
                ", 菜单权限：" + perms + '\'' +
                ", 菜单类型：" + type +
                ", 菜单图标：" + icon + '\'' +
                ", 菜单排序：" + orderNum +
                '}';
    }
}
