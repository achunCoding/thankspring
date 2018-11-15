package top.wycfight.thankspring.common.utils;

/**
 * @author: wycfight@163.com
 * @description: Redis所有keys
 * @create: 2018-11-15 11:33
 * @modified By:
 **/
public class RedisKeys {
    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}
