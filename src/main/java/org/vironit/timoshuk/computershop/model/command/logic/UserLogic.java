package org.vironit.timoshuk.computershop.model.command.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.dao.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.model.resource.MessageManager;

import java.util.HashMap;
import java.util.ResourceBundle;

public class UserLogic {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("regex");
    private static final Logger LOG = LogManager.getLogger(UserLogic.class);

    public static boolean checkLogin (String enterLogin){
        return enterLogin.matches(RESOURCE_BUNDLE.getString("login"));
    }

    public static boolean checkLoginFromDB (String enterLogin) throws DAOException {
        return new UserDAOImpl().checkLogin(enterLogin);
    }

    public static boolean checkPassword (String enterPassword){
        return enterPassword.matches(RESOURCE_BUNDLE.getString("password"));
    }

    public static boolean checkEmail (String enterEmail){
        return enterEmail.matches(RESOURCE_BUNDLE.getString("email"));
    }

    public static HashMap <String, String> checkUserData (String login, String password, String passworTwo, String email){
        HashMap <String, String> errorMessage = new HashMap<>();
        try {
            if(UserLogic.checkLogin(login)) {
                if (UserLogic.checkLoginFromDB(login)) {
                    errorMessage.put("errorLoginMessage", MessageManager.getProperty("message.loginInUse"));
                }
            }else {
                errorMessage.put("errorLoginMessage",MessageManager.getProperty("message.loginIncorrect"));
            }
        } catch (DAOException e) {
            LOG.error("DAO Exception");
        }
        if (!(UserLogic.checkPassword(password))){
            errorMessage.put("errorPasswordMessage", MessageManager.getProperty("message.passwordIncorrect"));
        }
        if (!(UserLogic.checkEmail(email))){
            errorMessage.put("errorEmailMessage", MessageManager.getProperty("message.emailIncorrect"));
        }
        if (password.equals(passworTwo)){
            errorMessage.put("errorPassEqualMessage", MessageManager.getProperty("message.passNotEqualsTwo"));
        }

        return errorMessage;
    }

}
