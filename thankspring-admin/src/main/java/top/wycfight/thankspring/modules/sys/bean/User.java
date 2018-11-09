package top.wycfight.thankspring.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 测试用户实体 增加swagger注解
 * @create: 2018-11-08 20:28
 * @modify By:
 **/
@Data
@ApiModel
public class User {
    /**
     * 主键ID
     */
    @ApiModelProperty(allowableValues = "主键Id")
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(allowableValues = "用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(allowableValues = "密码")
    private String password;
    /**
     * 创建时间
     */
    @ApiModelProperty(allowableValues = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(allowableValues = "更新时间")
    private Date updateTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
