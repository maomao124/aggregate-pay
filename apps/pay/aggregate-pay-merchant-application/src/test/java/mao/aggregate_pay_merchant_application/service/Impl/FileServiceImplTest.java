package mao.aggregate_pay_merchant_application.service.Impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.UnsupportedEncodingException;

import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_merchant_application.config.QNFileConfigurationProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FileServiceImpl.class, QNFileConfigurationProperties.class})
@ExtendWith(SpringExtension.class)
class FileServiceImplTest
{
    @Autowired
    private FileServiceImpl fileServiceImpl;

    @Autowired
    private QNFileConfigurationProperties qNFileConfigurationProperties;

    /**
     * Method under test: {@link FileServiceImpl#upload(byte[], String)}
     */
    @Test
    void testUpload() throws UnsupportedEncodingException
    {
        assertThrows(BusinessException.class, () -> this.fileServiceImpl.upload("AAAAAAAA".getBytes("UTF-8"), "foo.txt"));
    }

    /**
     * Method under test: {@link FileServiceImpl#init()}
     */
    @Test
    void testInit()
    {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     FileServiceImpl.qnFileConfigurationProperties

        this.fileServiceImpl.init();
    }
}

