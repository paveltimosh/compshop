package org.timoshuk.computershop.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.entity.users.UserType;

public class UserData {

    @Autowired
    public PasswordEncoder passwordEncoder;

    public static final String USER_LOGIN = "petrov12";
    public static final String USER_PASSWORD = "petrov";
    public static final String USER_FIRST_NAME = "Jean-Louis Brian";
    public static final String USER_EMAIL = "dasafsf@fsefsge";
    public static final String USER_LAST_NAME = "Dgigan";
    public static final String USER_PHONE = "298745652";
    public static final String USER_ADDRESS = "уStreet 5";
    public static final String CREDIT_CARD_NUMBER = "1111222233334444";
    public static final Integer USER_OWN_MONEY = 1500;

    public static final String USER_WRONG_PHONE = "123 456 78 90";

    /*public static final String BASIC_AUTH_VALUE = "Basic "
            + new String(new BCryptPasswordEncoder().encode(USER_LOGIN + ":" + USER_PASSWORD).getBytes());

    public static final String WRONG_BASIC_AUTH_VALUE = "Basic "
            + new String(new BCryptPasswordEncoder().encode(USER_LOGIN + "111").getBytes());*/

    public static UserDTO getUserDTO() {
        UserDTO userDTO = UserDTO.builder()

                .login(USER_LOGIN)
                .email(USER_EMAIL)
                .password(USER_PASSWORD)
                .passwordTwo(USER_PASSWORD)
                .firstName(USER_FIRST_NAME)
                .lastName(USER_LAST_NAME)
                .phoneNumber(USER_PHONE)
                .address(USER_ADDRESS)
                .idCard(CREDIT_CARD_NUMBER)
                .build();
        return userDTO;
    }
}
