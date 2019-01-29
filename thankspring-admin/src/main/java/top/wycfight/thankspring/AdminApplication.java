package top.wycfight.thankspring;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan(basePackages = {"top.wycfight.thankspring.modules.*.mapper"})
@ComponentScan(basePackages = {"top.wycfight.common","top.wycfight.thankspring"})
public class AdminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(AdminApplication.class);
    }
}
