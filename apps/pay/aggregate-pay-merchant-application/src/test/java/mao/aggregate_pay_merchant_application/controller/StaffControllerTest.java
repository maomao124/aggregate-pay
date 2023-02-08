package mao.aggregate_pay_merchant_application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.feign.StaffFeignClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StaffController.class})
@ExtendWith(SpringExtension.class)
class StaffControllerTest
{
    @Autowired
    private StaffController staffController;

    @MockBean
    private StaffFeignClient staffFeignClient;

    /**
     * Method under test: {@link StaffController#deleteStaff(Long)}
     */
    @Test
    void testDeleteStaff() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/my/staffs/{staffId}", "Uri Vars",
                "Uri Vars");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.staffController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link StaffController#queryStaffByPage(Integer, Integer)}
     */
    @Test
    void testQueryStaffByPage() throws Exception
    {
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.post("/my/staffs/page")
                .param("pageNo", "https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.staffController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link StaffController#saveStaff(StaffDTO)}
     */
    @Test
    void testSaveStaff() throws Exception
    {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(staffDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/my/staffs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.staffController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link StaffController#updateStaff(StaffDTO)}
     */
    @Test
    void testUpdateStaff() throws Exception
    {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setFullName("Dr Jane Doe");
        staffDTO.setFullname("Dr Jane Doe");
        staffDTO.setId(123L);
        staffDTO.setLastLoginTime(LocalDateTime.of(1, 1, 1, 1, 1));
        staffDTO.setMerchantId(123L);
        staffDTO.setMobile("Mobile");
        staffDTO.setPosition("Position");
        staffDTO.setStaffStatus(true);
        staffDTO.setStoreId(123L);
        staffDTO.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(staffDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/my/staffs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.staffController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

