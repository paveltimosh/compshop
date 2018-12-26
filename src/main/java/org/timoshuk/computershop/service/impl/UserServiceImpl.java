package org.timoshuk.computershop.service.impl;

import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.timoshuk.computershop.DAO.impl.UserDAOImpl;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.DTO.parser.UserDtoParser;
import org.timoshuk.computershop.entity.users.User;
import org.timoshuk.computershop.entity.users.UserType;
import org.timoshuk.computershop.exception.UserExistsException;
import org.timoshuk.computershop.exception.EntityNotFoundException;
import org.timoshuk.computershop.service.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDAO;

    @Autowired
    private UserDtoParser userDtoParser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public UserDTO findById(Long id) {
        User user = userDAO.findById(id);
        if (user == null){
            throw new EntityNotFoundException("User not found!");
        }
        return userDtoParser.createDTOFromEntity(user);
    }

    @Transactional
    @Override
    public List<UserDTO> findAll() {
        List<User> users = userDAO.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            userDTOList.add(userDtoParser.createDTOFromEntity(user));
        }
        return userDTOList;
    }

    @Transactional
    @Override
    public void createUser(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userDTO.setUserType(UserType.USER);
        User user = userDtoParser.createEntityFromDTO(userDTO);
        if(validateUser(user)) {
            userDAO.create(user);
        }
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
        return userDtoParser.createDTOFromEntity(userDAO.findByLogin(login));
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

    private boolean validateUser(User user) {
        boolean userValid = false;
        try {
            if (userDAO.checkLogin(user.getLogin())) {
                throw new UserExistsException("User with this login already exists!");
            }
            if (userDAO.checkEmail(user.getEmail())) {
                throw new UserExistsException("User with this email already exists!");
            }
            if (userDAO.checkBankCard(user.getIdCard())) {
                throw new UserExistsException("User with this bankcard's already exists!");
            }
        }catch (NonUniqueResultException e){

        }
        userValid = true;
        return userValid;
    }


}

