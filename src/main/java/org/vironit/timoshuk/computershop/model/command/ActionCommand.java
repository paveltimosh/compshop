package org.vironit.timoshuk.computershop.model.command;


import javax.servlet.http.HttpServletRequest;

public interface ActionCommand  {
    String execute (HttpServletRequest request);

}
