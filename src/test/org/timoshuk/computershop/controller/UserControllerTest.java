package org.timoshuk.computershop.controller;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.config.WebConfig;
import org.timoshuk.computershop.data.UserData;
import org.timoshuk.computershop.secure.WebSecurityConfig;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {WebConfig.class, WebSecurityConfig.class})
public class UserControllerTest {

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
    public void getUserByIdWithAuthorization() throws Exception{
        given().port(port).with().auth().preemptive().basic("pafafa", "topor")
                .header("Content-Type", "application/json")
                .when()
                .get( "/users/41")
                .then()
                .statusCode(200);
    }

    @Test
    public void getUserByIdWithWrongPassword() throws Exception{
        given().port(port).with().auth().preemptive().basic("pafafa", "wrongPassword")
                .header("Content-Type", "application/json")
                .when()
                .get( "/users/41")
                .then()
                .statusCode(401);
    }

    @Test
    public void getNotOwnUserById() throws Exception{
        given().port(port).with().auth().preemptive().basic("pafafa", "topor")
                .header("Content-Type", "application/json")
                .when()
                .get( "/users/16")
                .then()
                .statusCode(403);
    }

}
