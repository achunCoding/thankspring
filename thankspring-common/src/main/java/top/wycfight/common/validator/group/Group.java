package top.wycfight.common.validator.group;

import javax.validation.GroupSequence;

/**
 * @author: wycfight@163.com
 * @description: 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 * @create: 2018-11-13 13:42
 * @modified By:
 **/
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {
}
