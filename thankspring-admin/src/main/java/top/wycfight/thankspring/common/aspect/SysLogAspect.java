package top.wycfight.thankspring.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.wycfight.common.utils.HttpContextUtils;
import top.wycfight.common.utils.IPUtils;
import top.wycfight.thankspring.common.annotation.SysLog;
import top.wycfight.thankspring.modules.sys.bean.SysLogEntity;
import top.wycfight.thankspring.modules.sys.service.SysLogService;
import top.wycfight.thankspring.modules.sys.shiro.ShiroUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 系统日志，切面处理类
 * @create: 2018-12-12 08:24
 * @modified By:
 **/
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    /**
     * Pointcut ：切入点
     * annotation：当执行的方法上拥有指定的注解时生效。
     */
    @Pointcut("@annotation(top.wycfight.thankspring.common.annotation.SysLog)")
    public void logPointCut() {

    }

    /**
     * 环绕通知
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTimes = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTimes;

        // 保存日志
        saveSysLog(point, time);
        return result;

    }

    /**
     * 保存日志
     *
     * @param joinPoint 它新增了两个用于执行连接点方法的方法：
     * @param time      时间
     */
    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        // 获取方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLogEntity sysLogEntity = new SysLogEntity();
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null) {
            // 注解上的描述
            sysLogEntity.setOperation(sysLog.value());
        }

        // 获取执行的class
        String className = joinPoint.getTarget().getClass().getName();
        // 请求方法名
        String methodName = signature.getName();
        sysLogEntity.setMethod(className + "," + methodName + "()");
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = new Gson().toJson(args[0]);
            sysLogEntity.setParams(params);
        } catch (Exception e) {

        }

        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLogEntity.setIp(IPUtils.getIpAddr(request));
        // 获取用户名
        String username = ShiroUtils.getUserEntity().getUsername();
        sysLogEntity.setUsername(username);
        // 设置执行时长
        sysLogEntity.setTime(time);
        sysLogEntity.setCreateDate(new Date());
        sysLogEntity.setUpdateDate(new Date());
        // 保存系统日志
        sysLogService.insert(sysLogEntity);
    }


}
