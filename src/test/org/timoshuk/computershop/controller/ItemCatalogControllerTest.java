package org.timoshuk.computershop.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.timoshuk.computershop.config.WebConfig;
import org.timoshuk.computershop.controller.customer.ItemCatalogController;
import org.timoshuk.computershop.secure.WebSecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {WebConfig.class, WebSecurityConfig.class})
public class ItemCatalogControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ItemCatalogController itemCatalogController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemCatalogController).build();
    }

    @Test
    public void getAllCases() throws  Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/cases");
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(ok);

    }

    @Test
    public void getAllRAMs() throws  Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/rams");
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(ok);

    }

    @Test
    public void getAllCPUs() throws  Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/videocards");
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(ok);

    }

    @Test
    public void getAllVideoCards() throws  Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/cpus");
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(ok);

    }

    @Test
    public void getAllMotherBoards() throws  Exception{
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/motherboards");
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request)
                .andExpect(ok);

    }
}
