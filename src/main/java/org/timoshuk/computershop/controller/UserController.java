package org.timoshuk.computershop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.timoshuk.computershop.DTO.transfer.EditUserData;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.service.UserService;

import javax.servlet.http.HttpSession;

@SessionAttributes({"user","cart"})
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("userValidator")
    private Validator userValidator;

    private final static Logger LOG = LogManager.getLogger(UserController.class);

    @ModelAttribute("userDTO")
    public UserDTO createModel() {
        return new UserDTO();
    }


/*
    @PostMapping(value = "/login")
    public ModelAndView login (@RequestParam String login,
                               @RequestParam String password,
                               HttpSession session){
        ModelAndView model = new ModelAndView("login");
        System.out.println("user controller");
        try {
            UserDTO user = userService.findByLogin(login);
            if (user.getPassword().equals(password)) {
                HashMap<Item, Integer> cart = new HashMap<>();
                session.setAttribute("user", user);
                session.setAttribute("role", user.getUserType().toString());
                session.setAttribute("cart", cart);
                LOG.info("The user with login " + user.getLogin() + " is logged in");
                model.setViewName("redirect:register");
            }else {
                model.addObject("wrongPassword", MessageManager.getProperty("message.passwordError"));
            }
        }catch (NullPointerException e){
            model.addObject("userNotFound", MessageManager.getProperty("message.loginError"));
        }
        return model;
    }*/

    @PostMapping(value = "/changeProfile")
    public ModelAndView changeProfile(@SessionAttribute("user") UserDTO userDTO,
                                      @Validated(EditUserData.class) @ModelAttribute ("userDTO")UserDTO userDtoEdit,
                                      BindingResult bindingResult,
                                      HttpSession session){
        ModelAndView model = new ModelAndView();
        if(bindingResult.hasErrors()){
            model.setViewName("user/changeUserData");
            LOG.info("Editing of user is not valid:" + bindingResult);
            return model;
        }
        userDTO.setEmail(userDtoEdit.getEmail());
        userDTO.setFirstName(userDtoEdit.getFirstName());
        userDTO.setLastName(userDtoEdit.getLastName());
        userDTO.setAddress(userDtoEdit.getAddress());
        userDTO.setPhoneNumber(userDtoEdit.getPhoneNumber());
        userDTO.setIdCard(userDtoEdit.getIdCard());
        userService.update(userDTO);
        model.setViewName("redirect:user/profile");
        session.setAttribute("user", userDTO);
        return model;
    }



    /*@GetMapping("/logout")
    public String getLogoutPage (@RequestParam String login,
                                 HttpServletRequest request, HttpSession session){
        session.invalidate();
        request.getSession(true);
        LOG.info("The user with login " + login + " is logged out");
        return "main";
    }*/

    @GetMapping({"/profile",""})
    public String getShowProfilePage (){
        return "user/profile";
    }

    @GetMapping("/changeUserData")
    public String getChangeProfilePage(){
        return "user/changeUserData";
    }





    @GetMapping({"/"})
    public String mainPage(){
        return "main";
    }

    @GetMapping("/cart")
    public String showCart(){
        return "user/cart";
    }
}
