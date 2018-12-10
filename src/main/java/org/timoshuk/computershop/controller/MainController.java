package org.timoshuk.computershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.DTO.transfer.CreateNewUser;
import org.timoshuk.computershop.entity.users.UserType;
import org.timoshuk.computershop.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("userValidator")
    private Validator userValidator;

    @ModelAttribute("newUser")
    public UserDTO createModelUser() {
        return new UserDTO();
    }

    @PostMapping(value = "/register")
    public ModelAndView registerNewUser(@Validated(CreateNewUser.class) @ModelAttribute("newUser") UserDTO newUser,
                                        BindingResult bindingResult){
        ModelAndView model = new ModelAndView("main");
        userValidator.validate(newUser,bindingResult);
        if(bindingResult.hasErrors()){
            model.setViewName("register");
            return model;
        }
        model.addObject("registerSuccessfully","Registration completed successfully!");
        newUser.setUserType(UserType.USER);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userService.createUserThenAuthenticate(newUser);
        return model;
    }

    @GetMapping({"/main","/"})
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/login")
    public String loginPage(HttpSession session){
        System.out.println("возвращает страницу логина");
        System.out.println(session.getAttribute("user"));
        return "login";
    }

    @GetMapping({"/register"})
    public String getRegisterPage(){
        return "register";
    }
}
