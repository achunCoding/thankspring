package top.wycfight.thankspring.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 测试用户实体
 * @create: 2018-11-08 20:28
 * @modify By:
 **/
@Data
public class User {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
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
