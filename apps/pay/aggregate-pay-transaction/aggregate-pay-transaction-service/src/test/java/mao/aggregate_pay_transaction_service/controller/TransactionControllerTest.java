package mao.aggregate_pay_transaction_service.controller;

import mao.aggregate_pay_transaction_api.dto.QRCodeDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TransactionControllerTest
{
    /**
     * Method under test: {@link TransactionController#createStoreQRCode(QRCodeDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateStoreQRCode()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.TransactionController.createStoreQRCode(TransactionController.java:50)
        //   In order to prevent createStoreQRCode(QRCodeDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createStoreQRCode(QRCodeDto).
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionController transactionController = new TransactionController();
        transactionController.createStoreQRCode(new QRCodeDto());
    }
}

