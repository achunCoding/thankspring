package top.wycfight.thankspring.common.config;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2018-11-15 16:58
 * @modified By:
 **/
public class GeetestConfig02 {

    // 填入自己的captcha_id和private_key
    private static final String geetest_id = "002bc30ff1eef93e912f45814945e752";
    private static final String geetest_key = "4193a0e3247b82a26f563d595c447b1a";
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
