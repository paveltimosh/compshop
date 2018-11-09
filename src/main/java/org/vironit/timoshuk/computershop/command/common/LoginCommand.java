package org.vironit.timoshuk.computershop.command.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.resource.URLManager;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginCommand implements ActionCommand {

    private final static Logger LOG = LogManager.getLogger(LoginCommand.class);

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        try {
            User user = new UserDAOImpl().findByParameter("login", login);
            if(user != null){
                if (user.getPassword().equals(password)){
                    HashMap <Item, Integer> cart = new HashMap<>();
                    request.getSession().setAttribute("user", user);
                    request.getSession().setAttribute("role", user.getUserType().toString());
                    request.getSession().setAttribute("cart", cart);
                    page = URLManager.getProperty("path.page.main");
                }else {
                    request.setAttribute("wrongPassword", MessageManager.getProperty("message.passwordError"));
                    page = URLManager.getProperty("path.page.login");
                    LOG.info("The  user with login" + user.getLogin() + " is logged in");
                }
            }else {
                request.setAttribute("userNotFound", MessageManager.getProperty("message.loginError"));
                page = URLManager.getProperty("path.page.login");
            }
        } catch (SQLException e) {
            LOG.error("DAO Exception in method execute");
        }
        return page;
    }
}
