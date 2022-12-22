package mao.sms_manage.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.time.LocalDateTime;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.sms_entity.dto.BlackListDTO;
import mao.sms_entity.entity.BlackListEntity;

import mao.sms_manage.service.BlackListService;
import mao.tools_core.base.R;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BlackListController.class})
@ExtendWith(SpringExtension.class)
class BlackListControllerTest
{
    @Autowired
    private BlackListController blackListController;

    @MockBean
    private BlackListService blackListService;

    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private RedisTemplate redisTemplate;

    /**
     * Method under test: {@link BlackListController#page(BlackListDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.BlackListController.page(BlackListController.java:71)
        //   In order to prevent page(BlackListDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(BlackListDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        BlackListController blackListController = new BlackListController();
        blackListController.page(new BlackListDTO());
    }

    /**
     * Method under test: {@link BlackListController#delete(java.util.List)}
     */
    @Test
    void testDelete() throws Exception
    {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.get("/blacklist")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ArrayList<>()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.blackListController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link BlackListController#get(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGet()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.BlackListController.get(BlackListController.java:92)
        //   In order to prevent get(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   get(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new BlackListController()).get("42");
    }

    /**
     * Method under test: {@link BlackListController#upload(org.springframework.web.multipart.MultipartFile)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpload() throws IOException
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at org.springframework.web.method.annotation.RequestParamMethodArgumentResolver.handleMissingValue(RequestParamMethodArgumentResolver.java:196)
        //       at org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver.resolveArgument(AbstractNamedValueMethodArgumentResolver.java:114)
        //       at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:121)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:167)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:134)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent upload(MultipartFile)
        //   from throwing MultipartException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   upload(MultipartFile).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.BlackListController.upload(BlackListController.java:162)
        //   In order to prevent upload(MultipartFile)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   upload(MultipartFile).
        //   See https://diff.blue/R013 to resolve this issue.

        BlackListController blackListController = new BlackListController();
        blackListController.upload(new MockMultipartFile("Name", new ByteArrayInputStream("AAAAAAAA".getBytes("UTF-8"))));
    }

    /**
     * Method under test: {@link BlackListController#upload(org.springframework.web.multipart.MultipartFile)}
     */
    @Test
    void testUpload2() throws IOException
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at org.springframework.web.method.annotation.RequestParamMethodArgumentResolver.handleMissingValue(RequestParamMethodArgumentResolver.java:196)
        //       at org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver.resolveArgument(AbstractNamedValueMethodArgumentResolver.java:114)
        //       at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:121)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:167)
        //       at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:134)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:888)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent upload(MultipartFile)
        //   from throwing MultipartException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   upload(MultipartFile).
        //   See https://diff.blue/R013 to resolve this issue.

        BlackListController blackListController = new BlackListController();
        R<?> actualUploadResult = blackListController
                .upload(new MockMultipartFile("Name", new ByteArrayInputStream(new byte[]{})));
        assertEquals(-9, actualUploadResult.getCode());
        assertEquals("导入内容为空", actualUploadResult.getMsg());
        assertNull(actualUploadResult.getData());
    }

    /**
     * Method under test: {@link BlackListController#save(BlackListEntity)}
     */
    @Test
    void testSave() throws Exception
    {
        BlackListEntity blackListEntity = new BlackListEntity();
        blackListEntity.setContent("Not all who wander are lost");
        blackListEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        blackListEntity.setCreateUser("Create User");
        blackListEntity.setId("42");
        blackListEntity.setIsDelete(1);
        blackListEntity.setRemark("Remark");
        blackListEntity.setType("Type");
        blackListEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        blackListEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(blackListEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/blacklist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.blackListController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }

    /**
     * Method under test: {@link BlackListController#update(BlackListEntity)}
     */
    @Test
    void testUpdate() throws Exception
    {
        BlackListEntity blackListEntity = new BlackListEntity();
        blackListEntity.setContent("Not all who wander are lost");
        blackListEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        blackListEntity.setCreateUser("Create User");
        blackListEntity.setId("42");
        blackListEntity.setIsDelete(1);
        blackListEntity.setRemark("Remark");
        blackListEntity.setType("Type");
        blackListEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        blackListEntity.setUpdateUser("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(blackListEntity);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/blacklist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.blackListController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

