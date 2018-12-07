package org.vironit.timoshuk.computershop.service;

import org.vironit.timoshuk.computershop.DTO.UserDTO;
import org.vironit.timoshuk.computershop.entity.users.User;
import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
    void createUserThenAuthenticate(UserDTO entity);
    void update(UserDTO entity);
    void delete(User entity);
    void deleteById(Long id);
    UserDTO findByLogin (String login);
    boolean checkEmail (String email);
    boolean checkLogin(String login);
    boolean checkBankCard (String bankCard);

}
