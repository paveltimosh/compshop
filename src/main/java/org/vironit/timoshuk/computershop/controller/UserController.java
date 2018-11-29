package org.vironit.timoshuk.computershop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.vironit.timoshuk.computershop.command.common.LoginCommand;
import org.vironit.timoshuk.computershop.dto.UserDTO;
import org.vironit.timoshuk.computershop.dto.parser.UserDtoParser;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.service.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;

@SessionAttributes({"user","cart"})
@Controller
public class UserController {

    private UserService userService;

    private final static Logger LOG = LogManager.getLogger(LoginCommand.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserDtoParser userDtoParser;

    @ModelAttribute("userDTO")
    public UserDTO createModel() {

        return new UserDTO();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login (@RequestParam String login,
                               @RequestParam String password,
                               HttpSession session){

        ModelAndView model = new ModelAndView();
        UserDTO user = userService.findByLogin(login);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                HashMap<Item, Integer> cart = new HashMap<>();
                session.setAttribute("user", user);
                session.setAttribute("role", user.getUserType().toString());
                session.setAttribute("cart", cart);
                LOG.info("The user with login " + user.getLogin() + " is logged in");
                model.setViewName("main");
            }else {
                model.setViewName("login");
                model.addObject("wrongPassword", MessageManager.getProperty("message.passwordError"));
            }
        }else {
            model.setViewName("login");
            model.addObject("userNotFound", MessageManager.getProperty("message.loginError"));
        }
        return model;
    }
    @RequestMapping("register")
    public ModelAndView registerNewUser(@ModelAttribute User user){
        ModelAndView model = new ModelAndView();

        return model;
    }

    @RequestMapping(name = "change_profile", method = RequestMethod.POST)
    public ModelAndView changeProfile(@SessionAttribute("user") UserDTO user,
                                       @Valid @ModelAttribute UserDTO userDtoEdit,
                                       BindingResult bindingResult,
                                       HttpSession session){
        ModelAndView model = new ModelAndView();
        if(bindingResult.hasErrors()){
            model.setViewName("user/changeUserData");
            return model;
        }
        user.setEmail(userDtoEdit.getEmail());
        user.setFirstName(userDtoEdit.getFirstName());
        user.setLastName(userDtoEdit.getLastName());
        user.setAddress(userDtoEdit.getAddress());
        user.setPhoneNumber(userDtoEdit.getPhoneNumber());
        user.setIdCard(userDtoEdit.getIdCard());
        userService.update(user);
        model.setViewName("user/profile");
        session.setAttribute("user", user);
        return model;
    }

    @RequestMapping("/logout")
    public String getLogoutPage (@RequestParam String login,
                                 SessionStatus sessionStatus){
        sessionStatus.setComplete();
        LOG.info("The user with login " + login + " is logged out");
        return "main";
    }

    @RequestMapping("/profile")
    public String getShowProfilePage (){
        return "user/profile";
    }

    @RequestMapping("/changeUserData")
    public String getChangeProfilePage(){
        return "user/changeUserData";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }


    @GetMapping({"/main","/"})
    public String mainPage(){
        return "main";
    }
}
