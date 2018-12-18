package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.annotations.Update;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.common.validator.group.UpdateGroup;
import top.wycfight.thankspring.common.validator.check.MobileCheck;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 系统用户
 * 注解详情参考博客：https://www.cnblogs.com/fingerboy/p/6657118.html
 * @create: 2018-11-13 15:02
 * @modified By:
 **/
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    private Long userId;

    /**
     * 用户名 这里加上@NotBlank注解  判断长度是否大于0 ，使用gruops 属性来实现区别不同的校验需求
     */
    @NotBlank(message = "用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;
    /**
     * 密码
     * access属性:
     * 2.6版本新增属性，默认
     * Access.AUTO(不控制序列化反序列化权限)，
     * 此外还有READ_ONLY(仅可以序列化)、
     * WRITE_ONLY(仅可以反序列化)、READ_WRITE(序列化反序列化都可以)，
     * 一共四种。分别控制序列化反序列化的权限，所以JsonProperty注解使用该属性可以取代JsonIgnore注解，控制的更加精细。
     */
    @NotBlank(message = "密码不能为空", groups = AddGroup.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱 @Email 验证是否是邮箱格式
     */
    @NotBlank(message = "邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Email(message = "邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空",groups = {AddGroup.class,UpdateGroup.class})
    @MobileCheck(message = "请输入正确手机号")
//    @Pattern(message = "请输入正确手机号",groups = {AddGroup.class,UpdateGroup.class},regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$")
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 角色ID列表
     */
    @TableField(exist = false)
    private List<Long> roleIdList;

    /**
     * 创建时间 JsonFormat将Date转换成String  一般后台传值给前台时
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间 JsonFormat将Date转换成String  一般后台传值给前台时
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 部门ID
     */
//    @NotNull(message = "部门不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long deptId;

    /**
     * 部门名称   @TableField排除掉本类中的属性
     */
    @TableField(exist = false)
    private String deptName;

    /**
     * 设置：用户ID
     *
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户ID
     *
     * @return Long
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：用户名
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：邮箱
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：手机号
     *
     * @return String
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置：状态  0：禁用   1：正常
     *
     * @param status 状态  0：禁用   1：正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态  0：禁用   1：正常
     *
     * @return Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     *
     * @return Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 获取：创建时间
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

    /**
     * 获取：角色ID列表
     * @return
     */
    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    /**
     * 设置：角色ID列表
     * @param roleIdList
     */
    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    /**
     * 获取：盐
     * @return
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置：盐
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
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

    @Override
    public String toString() {
        return "SysUserEntity{" +
                "用户ID：" + userId +
                ", 用户名：" + username + '\'' +
                ", 密码：" + password + '\'' +
                ", 盐：" + salt + '\'' +
                ", 邮箱：" + email + '\'' +
                ", 手机：" + mobile + '\'' +
                ", 状态：" + status +
                ", 角色列表：" + roleIdList +
                ", 创建时间：" + createTime +
                ", 部门ID：" + deptId +
                ", 部门名称：" + deptName + '\'' +
                '}';
    }
}
