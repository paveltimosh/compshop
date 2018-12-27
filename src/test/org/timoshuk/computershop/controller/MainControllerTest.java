package org.timoshuk.computershop.controller;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.config.WebConfig;
import org.timoshuk.computershop.data.UserData;
import org.timoshuk.computershop.exception.UserExistsException;
import org.timoshuk.computershop.secure.WebSecurityConfig;
import org.timoshuk.computershop.util.TestUtil;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = {WebConfig.class, WebSecurityConfig.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private MainController mainController;


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
        RestAssured.port = port;
        RestAssured.registerParser("text/plain", Parser.JSON);
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

    @Test
    public void createUser_duplicateLogin() throws Exception{
        UserDTO userDTO = UserData.getUserDTO();
        userDTO.setLogin("pafafa");
        given().port(port).with().body(userDTO)
                .header("Content-Type", "application/json")
                .when()
                .post( "/registration")
                .then()
                .statusCode(406)
                .and()
                .body(containsString("User with this login already exists!"));
    }

    @Test
    public void createUser_duplicateEmail() throws Exception{
        UserDTO userDTO = UserData.getUserDTO();
        userDTO.setEmail("paf@rw");
        given().port(port).with().body(userDTO)
                .header("Content-Type", "application/json")
                .when()
                .post( "/registration")
                .then()
                .statusCode(406)
                .and()
                .body(containsString("User with this email already exists!"));
    }
}
