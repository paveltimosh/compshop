package org.vironit.timoshuk.computershop;

import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.dao.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.model.entity.users.User;
import org.vironit.timoshuk.computershop.model.entity.users.UserType;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();

        User user = User.builder().userType(UserType.ADMIN).email("мыло").
                firstName("Аркадий").lastName("Петрович").idCard(542).build();
        try {
            userDAO.updateUserPasswordById("123456",15L);
            userDAO.createUser(user);
            user.setEmail("Новое мыло радует");
            userDAO.update(user,15L);
            List<User> users = userDAO.findAll();
            for (User user1 : users) {
                System.out.println(user1);
            }


        } catch (DAOException daoExсeption) {
            daoExсeption.printStackTrace();
        }


}
}
