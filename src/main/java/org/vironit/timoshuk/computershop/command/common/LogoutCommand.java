package org.vironit.timoshuk.computershop.command.common;

import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = URLManager.getProperty("path.page.index");
        request.getSession().invalidate();
        request.getSession(true);
        return page;
    }
}
