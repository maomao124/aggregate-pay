package mao.aggregate_pay_gateway.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import mao.aggregate_pay_common.domain.RestResponse;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;

class HttpUtilTest
{
    /**
     * Method under test: {@link HttpUtil#writerError(RestResponse, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWriterError() throws IOException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:618)
        //       at org.apache.catalina.connector.Response.setContentType(Response.java:740)
        //       at mao.aggregate_pay_gateway.utils.HttpUtil.writerError(HttpUtil.java:26)
        //   In order to prevent writerError(RestResponse, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   writerError(RestResponse, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        RestResponse restResponse = new RestResponse(1, "Msg");

        HttpUtil.writerError(restResponse, new Response());
    }

    /**
     * Method under test: {@link HttpUtil#writerError(RestResponse, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testWriterError2() throws IOException
    {
        RestResponse restResponse = new RestResponse(1, "Msg");

        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        HttpUtil.writerError(restResponse, mockHttpServletResponse);
        assertTrue(mockHttpServletResponse.isCharset());
        assertEquals(1, mockHttpServletResponse.getStatus());
        assertNull(mockHttpServletResponse.getRedirectedUrl());
        assertEquals("utf-8", mockHttpServletResponse.getCharacterEncoding());
        assertEquals(1, mockHttpServletResponse.getHeaderNames().size());
        assertEquals("application/json,charset=utf-8", mockHttpServletResponse.getContentType());
    }

    /**
     * Method under test: {@link HttpUtil#writerError(RestResponse, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testWriterError3() throws IOException
    {
        RestResponse restResponse = new RestResponse(0, "Msg");

        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        HttpUtil.writerError(restResponse, mockHttpServletResponse);
        assertTrue(mockHttpServletResponse.isCharset());
        assertEquals(0, mockHttpServletResponse.getStatus());
        assertNull(mockHttpServletResponse.getRedirectedUrl());
        assertEquals("utf-8", mockHttpServletResponse.getCharacterEncoding());
        assertEquals(1, mockHttpServletResponse.getHeaderNames().size());
        assertEquals("application/json,charset=utf-8", mockHttpServletResponse.getContentType());
    }

    /**
     * Method under test: {@link HttpUtil#writerError(RestResponse, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testWriterError4() throws IOException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_gateway.utils.HttpUtil.writerError(HttpUtil.java:27)
        //   In order to prevent writerError(RestResponse, HttpServletResponse)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   writerError(RestResponse, HttpServletResponse).
        //   See https://diff.blue/R013 to resolve this issue.

        HttpUtil.writerError(null, new MockHttpServletResponse());
    }
}

