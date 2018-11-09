package top.wycfight.thankspring.modules.service.impl;

import org.springframework.stereotype.Service;
import top.wycfight.thankspring.bean.User;
import top.wycfight.thankspring.mapper.UserMapper;
import top.wycfight.thankspring.service.UserService;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author: wycfight@163.com
 * @description: 用户Controller
 * @create: 2018-11-08 20:37
 * @modify By:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Object listAll(int page, int size) {
        return null;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int remove(Integer userId) {
        return userMapper.remove(userId);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }
}