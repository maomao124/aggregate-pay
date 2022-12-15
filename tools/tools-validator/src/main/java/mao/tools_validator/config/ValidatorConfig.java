package mao.tools_validator.config;

import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.annotation.PostConstruct;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Project name(项目名称)：hibernate_validator_demo
 * Package(包名): mao.hibernate_validator_demo.config
 * Class(类名): ValidatorConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/29
 * Time(创建时间)： 13:21
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class ValidatorConfig
{
    private static final Logger log = LoggerFactory.getLogger(ValidatorConfig.class);

    @Bean
    public Validator validator()
    {
        ValidatorFactory validatorFactory =
                Validation.byProvider(HibernateValidator.class)
                        .configure()
                        //快速失败返回模式
                        .addProperty("hibernate.validator.fail_fast", "true")
                        .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    /**
     * 开启快速返回
     * 如果参数校验有异常，直接抛异常，不会进入到 controller，使用全局异常拦截进行拦截
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor()
    {
        MethodValidationPostProcessor postProcessor =
                new MethodValidationPostProcessor();
        /*设置validator模式为快速失败返回*/
        postProcessor.setValidator(validator());
        return postProcessor;
    }

    @PostConstruct
    public void init()
    {
        log.info("开启hibernate-validator快速返回");
    }
}
