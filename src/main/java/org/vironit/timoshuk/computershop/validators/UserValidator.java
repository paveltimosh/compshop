package org.vironit.timoshuk.computershop.validators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.service.UserService;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;


public class UserValidator {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("regex");
    private static final Logger LOG = LogManager.getLogger(UserValidator.class);

    public static boolean checkLogin (String enterLogin){
        return enterLogin.matches(RESOURCE_BUNDLE.getString("login"));
    }

    public static boolean checkLoginFromDB (String enterLogin) throws SQLException {
        return new UserDAOImpl().checkLogin(enterLogin);
    }

    public static boolean checkPassword (String enterPassword){
        return enterPassword.matches(RESOURCE_BUNDLE.getString("password"));
    }

    public static boolean checkEmail (String enterEmail){
        return enterEmail.matches(RESOURCE_BUNDLE.getString("email"));
    }

    public static boolean checkEmailFromDB (String enterEmail) throws SQLException {
        return new UserDAOImpl().checkEmail(enterEmail);
    }

    public static boolean checkFirstName (String enterFirstName){
        return enterFirstName.matches(RESOURCE_BUNDLE.getString("string"));
    }

    public static boolean checkLastName (String enterLastName){
        return enterLastName.matches(RESOURCE_BUNDLE.getString("string"));
    }

    public static boolean checkAddress (String enterAddrese){
        return enterAddrese.matches(RESOURCE_BUNDLE.getString("address"));
    }

    public static boolean checkPhoneNumber (String enterPhoneNumber){
        return enterPhoneNumber.matches(RESOURCE_BUNDLE.getString("phoneNumber"));
    }

    public static boolean checkIdCard (String enterIdCard){
        return enterIdCard.matches(RESOURCE_BUNDLE.getString("idBankCard"));
    }
    public static boolean checkIdCardFromDB (String bankCard) throws SQLException {
        return new UserDAOImpl().checkBankCard(bankCard);
    }

    public static HashMap <String, String> checkUserData (String login, String password, String passwordTwo, String email, String firstName,
                                                          String lastName, String phonenumber, String address, String idBankCard){
        HashMap <String, String> errorMessage = new HashMap<>();
        try {
            if(UserValidator.checkLogin(login)) {
                if (UserValidator.checkLoginFromDB(login)) {
                    errorMessage.put("errorLoginMessage", MessageManager.getProperty("message.loginInUse"));
                }
            }else {
                errorMessage.put("errorLoginMessage",MessageManager.getProperty("message.loginIncorrect"));
            }
            if ((UserValidator.checkEmail(email))){
                if(UserValidator.checkEmailFromDB(email)){
                    errorMessage.put("errorEmailMessage", MessageManager.getProperty("message.emailInUse"));
                }
            }else {
                errorMessage.put("errorEmailMessage", MessageManager.getProperty("message.emailIncorrect"));
            }
            if(UserValidator.checkIdCardFromDB(idBankCard)){
                errorMessage.put("errorIdBanCardInUseMessage", MessageManager.getProperty("message.idCardInUse"));
            }
        } catch (SQLException e) {
            LOG.error("DAO Exception");
        }
        if (!(UserValidator.checkPassword(password))){
            errorMessage.put("errorPasswordMessage", MessageManager.getProperty("message.passwordIncorrect"));
        }
        if (!password.equals(passwordTwo)){
            errorMessage.put("errorPassEqualMessage", MessageManager.getProperty("message.passNotEqualsTwo"));
        }
        if (!(UserValidator.checkFirstName(firstName))){
            errorMessage.put("errorFirstNameMessage",MessageManager.getProperty("message.firstNameIncorrect"));
        }
        if (!(UserValidator.checkLastName(lastName))){
            errorMessage.put("errorLastNameMessage",MessageManager.getProperty("message.lastNameIncorrect"));
        }
        if(UserValidator.checkIdCard(idBankCard)){
            if(idBankCard.length() != 16) {
                errorMessage.put("errorIdCardMessage",MessageManager.getProperty("message.idCardLengthNot16"));
            }
        }else {
            errorMessage.put("errorIdCardMessage", MessageManager.getProperty("message.idCardIncorrect"));
        }
        if(!UserValidator.checkPhoneNumber(phonenumber)){
            errorMessage.put("errorPhoneMessage",MessageManager.getProperty("message.phoneNumberIncorrect"));
        }
        return errorMessage;
    }


    public static HashMap<String, String> checkUserDataWithoutLoginPassword(User user, String email, String firstName, String lastName,
                                                                             String phoneNumber, String address, String idBankCard) {
        HashMap <String, String> errorMessage = new HashMap<>();
        try {
            if ((UserValidator.checkEmail(email))){
                if(!user.getEmail().equals(email) && UserValidator.checkEmailFromDB(email)){
                    errorMessage.put("errorEmailMessage", MessageManager.getProperty("message.emailInUse"));
                }
            }else {
                errorMessage.put("errorEmailMessage", MessageManager.getProperty("message.emailIncorrect"));
            }

        } catch (SQLException e) {
            LOG.error("DAO Exception");
        }
        if (!(UserValidator.checkFirstName(firstName))){
            errorMessage.put("errorFirstNameMessage",MessageManager.getProperty("message.firstNameIncorrect"));
        }
        if (!(UserValidator.checkLastName(lastName))){
            errorMessage.put("errorLastNameMessage",MessageManager.getProperty("message.lastNameIncorrect"));
        }
        try {
            if(UserValidator.checkIdCard(idBankCard)){
                if(!user.getIdCard().equals(idBankCard) && UserValidator.checkIdCardFromDB(idBankCard)){
                    errorMessage.put("errorIdBanCardInUseMessage", MessageManager.getProperty("message.idCardInUse"));
                }
                if(idBankCard.length() != 16) {
                    errorMessage.put("errorIdCardMessage",MessageManager.getProperty("message.idCardLengthNot16"));
                }
            }else {
                errorMessage.put("errorIdCardMessage", MessageManager.getProperty("message.idCardIncorrect"));
            }
        } catch (SQLException e) {
            LOG.error("DAO Exception");
        }
        if(!UserValidator.checkPhoneNumber(phoneNumber)){
            errorMessage.put("errorPhoneMessage",MessageManager.getProperty("message.phoneNumberIncorrect"));
        }
        return errorMessage;
    }
}
