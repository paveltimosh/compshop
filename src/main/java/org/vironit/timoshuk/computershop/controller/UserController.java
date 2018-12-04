package org.vironit.timoshuk.computershop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.vironit.timoshuk.computershop.dto.UserDTO;
import org.vironit.timoshuk.computershop.dto.parser.UserDtoParser;
import org.vironit.timoshuk.computershop.dto.transfer.CreateNewUser;
import org.vironit.timoshuk.computershop.dto.transfer.EditUserData;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.entity.users.UserType;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@SessionAttributes({"user","cart"})
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    private final static Logger LOG = LogManager.getLogger(UserController.class);

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

    @ModelAttribute("newUser")
    public UserDTO createModelUser() {
        return new UserDTO();
    }


    @PostMapping(value = "/login")
    public ModelAndView login (@RequestParam String login,
                               @RequestParam String password,
                               HttpSession session){
        ModelAndView model = new ModelAndView("login");
        try {
            UserDTO user = userService.findByLogin(login);
            if (user.getPassword().equals(password)) {
                HashMap<Item, Integer> cart = new HashMap<>();
                session.setAttribute("user", user);
                session.setAttribute("role", user.getUserType().toString());
                session.setAttribute("cart", cart);
                LOG.info("The user with login " + user.getLogin() + " is logged in");
                model.setViewName("main");
            }else {
                model.addObject("wrongPassword", MessageManager.getProperty("message.passwordError"));
            }
        }catch (NullPointerException e){
            model.addObject("userNotFound", MessageManager.getProperty("message.loginError"));
        }
        return model;
    }

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
        model.setViewName("user/profile");
        session.setAttribute("user", userDTO);
        return model;
    }

    @PostMapping(value = "/register")
    public ModelAndView registerNewUser(@Validated(CreateNewUser.class) @ModelAttribute("newUser") UserDTO newUser,
                                        BindingResult bindingResult){
        ModelAndView model = new ModelAndView("main");
        System.out.println("new user from form " + newUser);
        if(bindingResult.hasErrors()){
            model.setViewName("register");
            System.out.println(bindingResult);
            return model;
        }
        newUser.setUserType(UserType.USER);
        userService.createUserThenAuthenticate(newUser);
        return model;
    }

    @GetMapping("/logout")
    public String getLogoutPage (@RequestParam String login,
                                 HttpServletRequest request, HttpSession session){
        session.invalidate();
        request.getSession(true);
        LOG.info("The user with login " + login + " is logged out");
        return "main";
    }

    @GetMapping("/profile")
    public String getShowProfilePage (){
        return "user/profile";
    }

    @GetMapping("/changeUserData")
    public String getChangeProfilePage(){
        return "user/changeUserData";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping({"/register"})
    public String getRegisterPage(){
        return "register";
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
