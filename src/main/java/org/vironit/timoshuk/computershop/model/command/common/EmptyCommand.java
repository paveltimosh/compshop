package org.vironit.timoshuk.computershop.model.command.common;

import org.vironit.timoshuk.computershop.model.command.ActionCommand;
import org.vironit.timoshuk.computershop.model.resource.ConfigurationManager;

import javax.security.auth.login.Configuration;
import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
