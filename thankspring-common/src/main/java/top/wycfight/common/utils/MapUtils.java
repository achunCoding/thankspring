package top.wycfight.common.utils;

import java.util.HashMap;

/**
 * @author: wycfight@163.com
 * @description: Map工具类
 * @create: 2018-11-09 16:24
 * @modified By:
 **/
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
