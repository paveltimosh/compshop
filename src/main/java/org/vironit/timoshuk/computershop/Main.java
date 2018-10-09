package org.vironit.timoshuk.computershop;


import org.vironit.timoshuk.computershop.model.dao.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.model.entity.users.User;
import org.vironit.timoshuk.computershop.model.entity.users.UserType;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();


        User user = User.builder().userType(UserType.USER).id(454L).email("test@mail").firstName("Аркадий").lastName("Петрович").build();
  //      userDAO.createUser(user);
        
        List<User> users = userDAO.findAll();
        System.out.println(users);
    }
}
