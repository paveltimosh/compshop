package org.vironit.timoshuk.computershop.command;


import javax.servlet.http.HttpServletRequest;

@FunctionalInterface
public interface ActionCommand  {
    String execute (HttpServletRequest request);

}
