package org.timoshuk.computershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.timoshuk.computershop.DAO.impl.UserDAOImpl;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.DTO.parser.UserDtoParser;
import org.timoshuk.computershop.entity.users.User;
import org.timoshuk.computershop.service.UserService;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDAO;

    @Autowired
    private UserDtoParser userDtoParser;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public User findById(Long id) {
         return userDAO.findById(id);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Transactional
    @Override
    public void createUserThenAuthenticate(UserDTO userDTO) {
        User user = createUserEntityFromDTO(userDTO);
        userDAO.create(user);
    }

    @Transactional
    @Override
    public void update(UserDTO userDTO) {
        User user = createUserEntityFromDTO(userDTO);
        userDAO.update(user);
    }

    @Transactional
    @Override
    public void delete(User entity) {
        userDAO.delete(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Transactional
    @Override
    public UserDTO findByLogin (String login){

        return new UserDtoParser().createDTOFromEntity(userDAO.findByLogin(login));
    }

    @Transactional
    @Override
    public boolean checkEmail(String email) {
        return userDAO.checkEmail(email);
    }

    @Transactional
    @Override
    public boolean checkLogin(String login) {
        return userDAO.checkLogin(login);
    }

    @Transactional
    @Override
    public boolean checkBankCard(String bankCard) {
        return userDAO.checkBankCard(bankCard);
    }


    private User createUserEntityFromDTO(UserDTO userDTO){
        User user = User.builder().userType(userDTO.getUserType())
                .id(userDTO.getId())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .ownMoney(userDTO.getOwnMoney())
                .address(userDTO.getAddress())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phoneNumber(userDTO.getPhoneNumber())
                .userType(userDTO.getUserType())
                .idCard(userDTO.getIdCard())
                .build();
        return user;
    }


}

