package top.wycfight.thankspring.common.exception.handler;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.wycfight.common.exception.GlobalException;
import top.wycfight.common.utils.ResultData;


/**
 * @author: wycfight@163.com
 * @description: 统一异常处理
 * @create: 2018-11-19 09:55
 * @modified By:
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(GlobalException.class)
    public ResultData handleRRException(GlobalException e){
        ResultData resultData = new ResultData();
        resultData.put("code", e.getCode());
        resultData.put("msg", e.getMessage());
        return resultData;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResultData handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(), e);
        return ResultData.error("数据库中已存在该记录");
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResultData handleAuthorizationException(AuthorizationException e){
        logger.error(e.getMessage(), e);
        return ResultData.error("没有权限，请联系管理员授权");
    }

    @ExceptionHandler(Exception.class)
    public ResultData handleException(Exception e){
        logger.error(e.getMessage(), e);
        return ResultData.error();
    }
}
