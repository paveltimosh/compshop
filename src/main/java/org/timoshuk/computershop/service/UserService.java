package org.timoshuk.computershop.service;

import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.entity.users.User;

import java.util.List;

public interface UserService {

    UserDTO findById(Long id);
    List<UserDTO> findAll();
    UserDTO createUser(UserDTO entity);
    void update(UserDTO entity);
    void delete(User entity);
    void deleteById(Long id);
    UserDTO findByLogin (String login);
    boolean checkEmail (String email);
    boolean checkLogin(String login);
    boolean checkBankCard (String bankCard);


}
