package org.vironit.timoshuk.computershop.model.dao.impl;

import org.junit.*;

import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.entity.users.User;
import org.vironit.timoshuk.computershop.model.entity.users.UserType;

public class UserDAOImplTest {
    private UserDAOImpl userDAO;
    private User user ;

    @Before
    public void setUp() throws Exception {

         user = User.builder().userType(UserType.ADMIN).email("мыло").
                 firstName("Аркадий").lastName("Петрович").idCard(542).build();
    }

    @AfterClass
    public static void tearDown() throws Exception {

    }

    @Test
    public void createUser() {
        try {
            userDAO.createUser(user);
            User userExpected = userDAO.findUserById(99999999999L);
            Assert.assertEquals(user,userExpected);

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}