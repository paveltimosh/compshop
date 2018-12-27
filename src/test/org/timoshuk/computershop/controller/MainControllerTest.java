package org.timoshuk.computershop.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.config.WebConfig;
import org.timoshuk.computershop.data.UserData;
import org.timoshuk.computershop.secure.WebSecurityConfig;
import org.timoshuk.computershop.util.TestUtil;
import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@ContextConfiguration(classes = {WebConfig.class, WebSecurityConfig.class})
public class MainControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    @Rollback
    public void createdUser_ok() throws Exception {
        UserDTO userDTO = UserData.getUserDTO();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/registration")
                .accept(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(userDTO))
                .contentType(TestUtil.APPLICATION_JSON_UTF8);
        MvcResult result = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

}
