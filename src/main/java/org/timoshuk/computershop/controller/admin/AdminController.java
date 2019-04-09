package org.timoshuk.computershop.controller.admin;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.DTO.view.UserDTOview;
import org.timoshuk.computershop.exception.EntityNotFoundException;
import org.timoshuk.computershop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private UserService userService;

    @JsonView(UserDTOview.ShowUser.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> showAllUsers(){
        List<UserDTO> users = userService.findAll();
        return users;
    }

    @JsonView(UserDTOview.ShowUser.class)
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDTO showUserById(@PathVariable Long id){
        UserDTO user = userService.findById(id);
        if (user == null){
            throw new EntityNotFoundException("User not found.");
        }
        return user;
    }
}
