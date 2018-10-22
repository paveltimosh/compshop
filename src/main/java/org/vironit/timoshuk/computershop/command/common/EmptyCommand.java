package org.vironit.timoshuk.computershop.command.common;

import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
