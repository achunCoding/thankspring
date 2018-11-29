package top.wycfight.thankspring.common.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wycfight@163.com
 * @description: ES配置不加入此配置可能会报错 ES版本5.X版本之后
 *  最多的就是JDK，ES客户端和 ESjar包的版本冲突
 * @create: 2018-11-27 13:09
 * @modified By:
 **/
//@Slf4j
//@Configuration
//public class ElasticSearchConfiguration implements InitializingBean {
//    private final Logger logger = LoggerFactory.getLogger(ElasticSearchConfiguration.class);
//
//    static {
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        logger.info("****************************************************");
//        logger.info("es.set.netty.runtime.available.processors:{}",System.getProperty("es.set.netty.runtime.available.processors"));
//        logger.info("****************************************************");
//    }
//}
