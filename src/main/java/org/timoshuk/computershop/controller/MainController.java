package org.timoshuk.computershop.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.DTO.transfer.CreateNewUser;
import org.timoshuk.computershop.DTO.view.UserDTOview;
import org.timoshuk.computershop.service.UserService;

@RestController
@RequestMapping
public class MainController {

    @Autowired
    private UserService userService;

    @JsonView(UserDTOview.ShowUser.class)
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@Validated(CreateNewUser.class) @RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
        return userService.findByLogin(userDTO.getLogin());
    }
}
