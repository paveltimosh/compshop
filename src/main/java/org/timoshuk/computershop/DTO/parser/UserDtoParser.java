package org.timoshuk.computershop.DTO.parser;

import org.springframework.stereotype.Service;
import org.timoshuk.computershop.entity.users.User;
import org.timoshuk.computershop.DTO.UserDTO;

@Service
public class UserDtoParser  {

    public UserDTO createDTOFromEntity (User user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .idCard(user.getIdCard())
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
                .ownMoney(user.getOwnMoney())
                .address(user.getAddress())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .userType(user.getUserType())
                .build();
        return userDTO;
    }

    public User createEntityFromDTO(UserDTO userDTO){
        User user = User.builder()
                .id(userDTO.getId())
                .idCard(userDTO.getIdCard())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .ownMoney(userDTO.getOwnMoney())
                .address(userDTO.getAddress())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phoneNumber(userDTO.getPhoneNumber())
                .userType(userDTO.getUserType())
                .build();
        return user;
    }
}
