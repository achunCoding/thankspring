package top.wycfight.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 返回数据
 * @create: 2018-11-09 16:32
 * @modified By:
 **/
public class ResultData extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultData() {
        put("code", 200);
        put("msg", "success");
    }

    public static ResultData error() {
        return error(500, "未知错误，请联系管理员");
    }

    public static ResultData error(String msg) {
        return error(500, msg);
    }

    public static ResultData error(int code, String msg) {
        ResultData r = new ResultData();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultData ok(String msg) {
        ResultData r = new ResultData();
        r.put("msg", msg);
        return r;
    }

    public static ResultData ok(Map<String, Object> map) {
        ResultData r = new ResultData();
        r.putAll(map);
        return r;
    }

    public static ResultData ok() {
        return new ResultData();
    }

    @Override
    public ResultData put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
