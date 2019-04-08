package org.vironit.timoshuk.computershop.command.common;

import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = URLManager.getProperty("path.page.index");
        return page;
    }
}