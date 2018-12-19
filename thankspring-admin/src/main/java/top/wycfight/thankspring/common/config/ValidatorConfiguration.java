package top.wycfight.thankspring.common.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author: wycfight@163.com
 * @description: Hibernate validator 配置
 * @create: 2018-12-19 08:47
 * @modified By:
 **/
@Configuration
public class ValidatorConfiguration {
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast","true")
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }
}
