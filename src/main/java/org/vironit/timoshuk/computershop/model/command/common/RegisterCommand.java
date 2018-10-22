package org.vironit.timoshuk.computershop.model.command.common;

import org.vironit.timoshuk.computershop.model.command.ActionCommand;
import org.vironit.timoshuk.computershop.model.command.logic.UserLogic;
import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.dao.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.model.entity.users.User;
import org.vironit.timoshuk.computershop.model.resource.ConfigurationManager;
import org.vironit.timoshuk.computershop.model.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RegisterCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final  String PARAM_NAME_PASSWORD_TWO = "passwordTwo";
    private static final String PARAM_NAME_EMAIL = "email";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String passwordTwo = request.getParameter(PARAM_NAME_PASSWORD_TWO);
        String email = request.getParameter(PARAM_NAME_EMAIL);

        HashMap <String, String> errorMessages = UserLogic.checkUserData(login, password, passwordTwo, email);
        if (errorMessages.isEmpty()){
            User user = User.builder().login(login).password(password).email(email).build();
            try {
                if (new UserDAOImpl().createEntity(user)){
                    request.setAttribute("registerSuccess", MessageManager.getProperty("message.registerSuccess"));
                    //TODO
                    page = ConfigurationManager.getProperty("path.page.index");
                }
                else {
                    request.setAttribute("", MessageManager.getProperty("message.registerUnSuccess"));
                    page = ConfigurationManager.getProperty("path.page.register");
                }
            } catch (DAOException e) {
                e.printStackTrace();
            }
        } else {
            for (Map.Entry<String, String> entry: errorMessages.entrySet()){
                request.setAttribute(entry.getKey(), entry.getValue());
            }
            page = ConfigurationManager.getProperty("path.page.register");
        }
        return page;
    }
}
