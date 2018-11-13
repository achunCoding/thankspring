package top.wycfight.thankspring.common.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: wycfight@163.com
 * @description: SpringBoot中使用AOP 监控sql耗时
 * @create: 2018-11-09 08:32
 * @modified By:
 **/
@Aspect
@Component
public class MapperAspect {
    private static final Logger logger = LoggerFactory.getLogger(MapperAspect.class);

    @AfterReturning("execution(* top.wycfight.thankspring.modules.sys.mapper.*Mapper.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        logger.info("Completed: " + joinPoint);
    }

    /**
     * 监控com.quick.druid.mapper..*Mapper及其子包的所有public方法
     */
    @Pointcut("execution(* top.wycfight.thankspring.modules.sys.mapper.*Mapper.*(..))")
    private void pointCutMethod() {
    }

    /**
     * 声明环绕通知
     *
     * @param pjp pjp
     * @return
     * @throws Throwable
     */
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.nanoTime();
        Object obj = pjp.proceed();
        long end = System.nanoTime();

        logger.info("调用Mapper方法：{}，\n参数：{}，\n执行耗时：{}纳秒，\r\n耗时：{}毫秒，\r\n耗时：{}秒",
                pjp.getSignature().toString(), Arrays.toString(pjp.getArgs()),
                (end - begin), (end - begin) / 1000000, (end - begin) / 1000000000);
        return obj;
    }


}
