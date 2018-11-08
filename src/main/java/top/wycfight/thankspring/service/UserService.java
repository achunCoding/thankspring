package top.wycfight.thankspring.service;

import top.wycfight.thankspring.bean.User;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2018-11-08 20:38
 * @modify By:
 **/
public interface  UserService {
    Object listAll(int page, int size);

    int insert(User user);

    int remove(Integer userId);

    int update(User user);
}
