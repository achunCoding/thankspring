package top.wycfight.common.exception;

/**
 * @author: wycfight@163.com
 * @description: 自定义异常
 * @create: 2018-11-09 16:45
 * @modified By:
 **/
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public GlobalException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public GlobalException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public GlobalException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public GlobalException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    /**
     * 获取：提示信息
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置：提示信息
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取：code
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置：code
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }
}
