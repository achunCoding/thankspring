package top.wycfight.thankspring.mapper;
import org.apache.ibatis.annotations.*;
import top.wycfight.thankspring.bean.User;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 用户Controller
 * @create: 2018-11-08 20:37
 * @modify By:
 **/
@Mapper
public interface UserMapper {

    @Select({
            "select * from user"
    })
    List<User> listAll();

    @Insert({
            "insert into user(`username`, `password`) values(#{username}, #{password})"
    })
    int insert(User user);

    @Delete({
            "delete from user where id = #{userId}"
    })
    int remove(Integer userId);

    @Update({
            "update user set username = #{username}, password = #{password} where id = #{id}"
    })
    int update(User user);
}
