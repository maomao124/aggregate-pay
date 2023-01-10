package mao.aggregate_pay_sms.config;


import mao.aggregate_pay_sms.handler.AbstractVerificationHandler;
import mao.aggregate_pay_sms.handler.SmsNumberVerificationHandler;
import mao.aggregate_pay_sms.sms.SmsService;
import mao.aggregate_pay_sms.sms.qcloud.QCloudSmsService;
import mao.aggregate_pay_sms.store.VerificationStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class BusinessConfig
{

    /**
     * 验证存储
     */
    @Autowired
    private VerificationStore verificationStore;

    /**
     * 短信服务
     */
    @Autowired
    private SmsService smsService;

    /**
     * 短信验证处理器数量
     *
     * @return {@link SmsNumberVerificationHandler}
     */
    @Bean
    public SmsNumberVerificationHandler smsNumberVerificationHandler()
    {
        SmsNumberVerificationHandler smsNumberVerificationHandler = new SmsNumberVerificationHandler("sms", 6);
        smsNumberVerificationHandler.setVerificationStore(verificationStore);
        smsNumberVerificationHandler.setSmsService(smsService);
        return smsNumberVerificationHandler;
    }

    /**
     * 验证处理程序映射
     *
     * @return {@link Map}<{@link String}, {@link AbstractVerificationHandler}>
     */
    @Bean
    public Map<String, AbstractVerificationHandler> verificationHandlerMap()
    {
        List<AbstractVerificationHandler> verificationHandlerList = new ArrayList<>();
        verificationHandlerList.add(smsNumberVerificationHandler());

        Map<String, AbstractVerificationHandler> verificationHandlerMap = new HashMap<>();
        for (AbstractVerificationHandler handler : verificationHandlerList)
        {
            verificationHandlerMap.put(handler.getName(), handler);
        }
        return verificationHandlerMap;
    }

}
