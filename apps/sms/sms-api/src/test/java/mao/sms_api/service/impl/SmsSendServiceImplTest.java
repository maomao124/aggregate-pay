package mao.sms_api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import mao.sms_api.service.BlackListService;
import mao.sms_api.service.ConfigService;
import mao.sms_api.service.PlatformService;
import mao.sms_api.service.SignatureService;
import mao.sms_api.service.TemplateService;
import mao.sms_api.service.TimingPushService;
import mao.sms_dao.mapper.ReceiveLogMapper;
import mao.sms_entity.dto.SmsBatchParamsDTO;
import mao.sms_entity.dto.SmsParamsDTO;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SmsSendServiceImpl.class, StringRedisTemplate.class})
@ExtendWith(SpringExtension.class)
class SmsSendServiceImplTest
{
    @MockBean
    private BlackListService blackListService;

    @MockBean
    private ConfigService configService;

    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private PlatformService platformService;

    @MockBean
    private ReceiveLogMapper receiveLogMapper;

    @MockBean
    private SignatureService signatureService;

    @Autowired
    private SmsSendServiceImpl smsSendServiceImpl;

    @MockBean
    private TemplateService templateService;

    @MockBean
    private TimingPushService timingPushService;

    /**
     * Method under test: {@link SmsSendServiceImpl#send(SmsParamsDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSend()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        SmsParamsDTO smsParamsDTO = new SmsParamsDTO();
        smsParamsDTO.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        smsParamsDTO.setEncryption("Encryption");
        smsParamsDTO.setMobile("Mobile");
        smsParamsDTO.setParams(new HashMap<>());
        smsParamsDTO.setSendTime("Send Time");
        smsParamsDTO.setSignature("Signature");
        smsParamsDTO.setTemplate("Template");
        smsParamsDTO.setTimestamp("Timestamp");
        this.smsSendServiceImpl.send(smsParamsDTO);
    }

    /**
     * Method under test: {@link SmsSendServiceImpl#batchSend(SmsBatchParamsDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBatchSend()
    {
        // TODO: Complete this test.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   See https://diff.blue/R026 to resolve this issue.

        SmsBatchParamsDTO smsBatchParamsDTO = new SmsBatchParamsDTO();
        smsBatchParamsDTO.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        smsBatchParamsDTO.setBatchCode("Batch Code");
        smsBatchParamsDTO.setEncryption("Encryption");
        smsBatchParamsDTO.setMobile(new ArrayList<>());
        smsBatchParamsDTO.setParams(new ArrayList<>());
        smsBatchParamsDTO.setSendTime("Send Time");
        smsBatchParamsDTO.setSignature(new ArrayList<>());
        smsBatchParamsDTO.setTemplate(new ArrayList<>());
        smsBatchParamsDTO.setTimestamp("Timestamp");
        this.smsSendServiceImpl.batchSend(smsBatchParamsDTO);
    }
}

