package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.dao.DAOException;
import org.vironit.timoshuk.computershop.dao.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.resource.URLManager;
import org.vironit.timoshuk.computershop.validators.UserValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UpdateUserDataCommand implements ActionCommand {

    private final static Logger LOG = LogManager.getLogger(UpdateUserDataCommand.class);

    private static final String PARAM_NAME_USER_ID = "userId";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_FIRST_NAME = "firstName";
    private static final String PARAM_NAME_LAST_NAME = "lastName";
    private static final String PARAM_NAME_PHONE_NUMBER ="phoneNumber";
    private static final String PARAM_NAME_ADDRESS = "address";
    private static final String PARAM_NAME_ID_BANK_CARD = "idBankCard";

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        Long userId = Long.valueOf(request.getParameter(PARAM_NAME_USER_ID));
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String firstName = request.getParameter(PARAM_NAME_FIRST_NAME);
        String lastName = request.getParameter(PARAM_NAME_LAST_NAME);
        String phoneNumber = request.getParameter(PARAM_NAME_PHONE_NUMBER);
        String address = request.getParameter(PARAM_NAME_ADDRESS);
        String idBankCard = request.getParameter(PARAM_NAME_ID_BANK_CARD);

        try {
            UserDAOImpl userDAO = new UserDAOImpl();
            User user = userDAO.findEntityById(userId);
            HashMap<String, String> errorMessages = UserValidator.checkUserDataWithoutLoginPassword( user, email, firstName,lastName, phoneNumber, address, idBankCard);

            if(errorMessages.isEmpty() && user != null){
                user.setEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPhoneNumber(phoneNumber);
                user.setAddress(address);
                user.setIdCard(idBankCard);
                if(userDAO.update(user)){
                    User updatedUser = userDAO.findEntityById(userId);
                    request.setAttribute("user", updatedUser);
                    page = URLManager.getProperty("path.page.user.profile");
                }else {
                    page = URLManager.getProperty("path.page.user.changeUser");
                }
            }else {
                for (Map.Entry<String, String> entry: errorMessages.entrySet()){
                    request.setAttribute(entry.getKey(), entry.getValue());
                    System.out.println(entry.getKey()+ entry.getValue());
                }
                page = URLManager.getProperty("path.page.user.changeUser");
            }
        } catch (DAOException e) {
            LOG.error("DAOException");
        }
        return page;
    }
}

