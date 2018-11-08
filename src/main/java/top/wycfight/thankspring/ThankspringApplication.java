package top.wycfight.thankspring;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class ThankspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThankspringApplication.class, args);
    }
}
