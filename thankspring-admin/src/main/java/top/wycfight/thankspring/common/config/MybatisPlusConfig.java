package top.wycfight.thankspring.common.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wycfight@163.com
 * @description: MybatisPlus 分页插件配置
 * @create: 2018-12-15 12:25
 * @modify By:
 **/
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
