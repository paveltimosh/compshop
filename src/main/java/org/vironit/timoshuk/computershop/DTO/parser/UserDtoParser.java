package org.vironit.timoshuk.computershop.dto.parser;

import org.springframework.stereotype.Service;
import org.vironit.timoshuk.computershop.dto.UserDTO;
import org.vironit.timoshuk.computershop.entity.users.User;

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
}
