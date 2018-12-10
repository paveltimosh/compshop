package org.timoshuk.computershop.validator;

import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.entity.users.User;
import org.timoshuk.computershop.service.UserService;

@Service
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    MessageSource messageSource;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserDTO userDTO = (UserDTO)obj;
        try {
            if(userService.checkLogin(userDTO.getLogin()))
            errors.rejectValue("login","LogInUse", new Object[]{"'login'"}, "User with this login already registered, please, choose another!");
        }catch (NonUniqueResultException e){
        }
        try {
            if(userService.checkEmail(userDTO.getEmail()))
            errors.rejectValue("email","EmailInUse", new Object[]{"'email'"}, "User with this email already registered, please, choose another!");
        }catch (NonUniqueResultException e){
        }
        try {
            if(userService.checkBankCard(userDTO.getIdCard()))
            errors.rejectValue("idCard","BankcardInUse", new Object[]{"'idCard'"}, "User with this bankcard's id already registered, please, choose another!");
        }catch (NonUniqueResultException e){
        }

    }
}
