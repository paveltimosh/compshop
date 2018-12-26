package org.timoshuk.computershop.controller.customer;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.DTO.transfer.EditUserData;
import org.timoshuk.computershop.DTO.view.UserDTOview;
import org.timoshuk.computershop.exception.AccessDeniedException;
import org.timoshuk.computershop.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(UserDTOview.ShowUser.class)
    public UserDTO getUser(@PathVariable("id") Long id,
                           Principal principal){
        UserDTO userDTO = userService.findById(id);
        if (!principal.getName().equals(userDTO.getLogin())){
            throw new AccessDeniedException("You cannot see this account, because you are not the owner!");
        }
        return userDTO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(UserDTOview.ShowUser.class)
    public UserDTO changeUser(@PathVariable("id") Long id,
                              @Validated(EditUserData.class) @RequestBody UserDTO userDTO,
                              Principal principal){
        UserDTO userDTOfromDB = userService.findById(id);
        if (principal.getName().equals(userDTOfromDB.getLogin())){
            BeanUtils.copyProperties(userDTO, userDTOfromDB, "id", "login", "password", "ownMoney", "userType");
            userService.update(userDTOfromDB);
        }else {
            throw new AccessDeniedException("You can not change this account, because you are not its owner!");
        }
        return userService.findById(id);
    }
}
