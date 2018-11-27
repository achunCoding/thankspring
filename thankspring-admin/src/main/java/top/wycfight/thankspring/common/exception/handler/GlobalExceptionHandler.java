package top.wycfight.thankspring.common.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.wycfight.thankspring.common.result.ErrorInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wycfight@163.com
 * @description: 统一异常处理
 * @create: 2018-11-19 09:55
 * @modified By:
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public ErrorInfo<String>  defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ErrorInfo<String> r = new ErrorInfo<>();
//        r.setMessage(e.getMessage());
//        r.setCode(ErrorInfo.ERROR);
//        r.setData("Some Data");
//        r.setUrl(req.getRequestURL().toString());
//        return r;
//    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler01(HttpServletRequest req, Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
