package top.wycfight.thankspring.service;

import top.wycfight.thankspring.bean.User;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2018-11-08 20:38
 * @modify By:
 **/
public interface  UserService {
    /**
     * 查询所有用户
     * @param page 当前页数
     * @param size 长度
     * @return
     */
    Object listAll(int page, int size);

    /**
     * 添加用户
     * @param user 用户实体
     * @return
     */
    int insert(User user);

    /**
     * 移除用户
     * @param userId 用户id
     * @return
     */
    int remove(Integer userId);

    /**
     * 更新用户
     * @param user 用户实体
     * @return
     */
    int update(User user);
}
