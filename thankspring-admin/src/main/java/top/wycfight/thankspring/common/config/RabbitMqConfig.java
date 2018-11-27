package top.wycfight.thankspring.common.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wycfight@163.com
 * @description: rabbit配置
 * @create: 2018-11-26 15:27
 * @modified By:
 **/
@Configuration
@EnableRabbit
public class RabbitMqConfig {


    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
