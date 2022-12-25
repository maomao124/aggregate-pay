package mao.sms_api.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import mao.sms_entity.dto.SmsBatchParamsDTO;
import mao.sms_entity.dto.SmsParamsDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SmsSendControllerTest
{
    /**
     * Method under test: {@link SmsSendController#send(SmsParamsDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSend()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_api.controller.SmsSendController.send(SmsSendController.java:56)
        //   In order to prevent send(SmsParamsDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   send(SmsParamsDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SmsSendController smsSendController = new SmsSendController();

        SmsParamsDTO smsParamsDTO = new SmsParamsDTO();
        smsParamsDTO.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        smsParamsDTO.setEncryption("Encryption");
        smsParamsDTO.setMobile("Mobile");
        smsParamsDTO.setParams(new HashMap<>());
        smsParamsDTO.setSendTime("Send Time");
        smsParamsDTO.setSignature("Signature");
        smsParamsDTO.setTemplate("Template");
        smsParamsDTO.setTimestamp("Timestamp");
        smsSendController.send(smsParamsDTO);
    }

    /**
     * Method under test: {@link SmsSendController#send(SmsParamsDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSend2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_api.controller.SmsSendController.send(SmsSendController.java:56)
        //   In order to prevent send(SmsParamsDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   send(SmsParamsDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SmsSendController smsSendController = new SmsSendController();
        SmsParamsDTO smsParamsDTO = mock(SmsParamsDTO.class);
        doNothing().when(smsParamsDTO).setAccessKeyId((String) any());
        doNothing().when(smsParamsDTO).setEncryption((String) any());
        doNothing().when(smsParamsDTO).setSendTime((String) any());
        doNothing().when(smsParamsDTO).setTimestamp((String) any());
        doNothing().when(smsParamsDTO).setMobile((String) any());
        doNothing().when(smsParamsDTO).setParams((java.util.Map<String, String>) any());
        doNothing().when(smsParamsDTO).setSignature((String) any());
        doNothing().when(smsParamsDTO).setTemplate((String) any());
        smsParamsDTO.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        smsParamsDTO.setEncryption("Encryption");
        smsParamsDTO.setMobile("Mobile");
        smsParamsDTO.setParams(new HashMap<>());
        smsParamsDTO.setSendTime("Send Time");
        smsParamsDTO.setSignature("Signature");
        smsParamsDTO.setTemplate("Template");
        smsParamsDTO.setTimestamp("Timestamp");
        smsSendController.send(smsParamsDTO);
    }

    /**
     * Method under test: {@link SmsSendController#batchSend(SmsBatchParamsDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBatchSend()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_api.controller.SmsSendController.batchSend(SmsSendController.java:80)
        //   In order to prevent batchSend(SmsBatchParamsDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   batchSend(SmsBatchParamsDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SmsSendController smsSendController = new SmsSendController();

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
        smsSendController.batchSend(smsBatchParamsDTO);
    }

    /**
     * Method under test: {@link SmsSendController#batchSend(SmsBatchParamsDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBatchSend2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_api.controller.SmsSendController.batchSend(SmsSendController.java:80)
        //   In order to prevent batchSend(SmsBatchParamsDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   batchSend(SmsBatchParamsDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        SmsSendController smsSendController = new SmsSendController();
        SmsBatchParamsDTO smsBatchParamsDTO = mock(SmsBatchParamsDTO.class);
        doNothing().when(smsBatchParamsDTO).setAccessKeyId((String) any());
        doNothing().when(smsBatchParamsDTO).setEncryption((String) any());
        doNothing().when(smsBatchParamsDTO).setSendTime((String) any());
        doNothing().when(smsBatchParamsDTO).setTimestamp((String) any());
        doNothing().when(smsBatchParamsDTO).setBatchCode((String) any());
        doNothing().when(smsBatchParamsDTO).setMobile((java.util.List<String>) any());
        doNothing().when(smsBatchParamsDTO).setParams((java.util.List<LinkedHashMap<String, String>>) any());
        doNothing().when(smsBatchParamsDTO).setSignature((java.util.List<String>) any());
        doNothing().when(smsBatchParamsDTO).setTemplate((java.util.List<String>) any());
        smsBatchParamsDTO.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        smsBatchParamsDTO.setBatchCode("Batch Code");
        smsBatchParamsDTO.setEncryption("Encryption");
        smsBatchParamsDTO.setMobile(new ArrayList<>());
        smsBatchParamsDTO.setParams(new ArrayList<>());
        smsBatchParamsDTO.setSendTime("Send Time");
        smsBatchParamsDTO.setSignature(new ArrayList<>());
        smsBatchParamsDTO.setTemplate(new ArrayList<>());
        smsBatchParamsDTO.setTimestamp("Timestamp");
        smsSendController.batchSend(smsBatchParamsDTO);
    }
}

