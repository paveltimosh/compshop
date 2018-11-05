package org.vironit.timoshuk.computershop.command.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.entity.users.UserType;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.resource.URLManager;
import org.vironit.timoshuk.computershop.validators.UserValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RegisterCommand implements ActionCommand {

    private final static Logger LOG = LogManager.getLogger(RegisterCommand.class);

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String PARAM_NAME_PASSWORD_TWO = "passwordTwo";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_FIRST_NAME = "firstName";
    private static final String PARAM_NAME_LAST_NAME = "lastName";
    private static final String PARAM_NAME_PHONE_NUMBER ="phoneNumber";
    private static final String PARAM_NAME_ADDRESS = "address";
    private static final String PARAM_NAME_ID_BANK_CARD = "idBankCard";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        String passwordTwo = request.getParameter(PARAM_NAME_PASSWORD_TWO);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String firstName = request.getParameter(PARAM_NAME_FIRST_NAME);
        String lastName = request.getParameter(PARAM_NAME_LAST_NAME);
        String phoneNumber = request.getParameter(PARAM_NAME_PHONE_NUMBER);
        String address = request.getParameter(PARAM_NAME_ADDRESS);
        String idBankCard = request.getParameter(PARAM_NAME_ID_BANK_CARD);

        HashMap <String, String> errorMessages = UserValidator.checkUserData(login, password, passwordTwo, email, firstName,lastName, phoneNumber, address, idBankCard);

        if (errorMessages.isEmpty()){
            User user = User.builder().userType(UserType.USER).login(login).password(password).email(email).firstName(firstName).lastName(lastName)
                    .phoneNumber(phoneNumber).address(address).idCard(idBankCard).build();
            try {
                new UserDAOImpl().create(user);
                if (new UserDAOImpl().findById(user.getId()).equals(user) ){
                    request.setAttribute("registerSuccess", MessageManager.getProperty("message.registerSuccess"));
                    page = URLManager.getProperty("path.page.login");
                    LOG.info("The registration of user with login" + user.getLogin() + " is successful");
                }
                else {
                    request.setAttribute("", MessageManager.getProperty("message.registerUnSuccess"));
                    page = URLManager.getProperty("path.page.register");
                }
            } catch (SQLException e) {
                LOG.error("DAO Exception in method execute");
            }
        } else {
            for (Map.Entry<String, String> entry: errorMessages.entrySet()){
                request.setAttribute(entry.getKey(), entry.getValue());
            }
            page = URLManager.getProperty("path.page.register");
        }
        return page;
    }
}
