package top.wycfight.thankspring.common.config;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2018-11-15 16:28
 * @modified By:
 **/
public class GeetestConfig01 {
    // 填入自己的captcha_id和private_key
    private static final String geetest_id = "48a6ebac4ebc6642d68c217fca33eb4d";
    private static final String geetest_key = "4f1c085290bec5afdc54df73535fc361";
    private static final boolean newfailback = true;

    public static final String getGeetest_id() {
        return geetest_id;
    }

    public static final String getGeetest_key() {
        return geetest_key;
    }

    public static final boolean isnewfailback() {
        return newfailback;
    }

}
