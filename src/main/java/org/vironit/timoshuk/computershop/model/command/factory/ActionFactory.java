package org.vironit.timoshuk.computershop.model.command.factory;

import org.vironit.timoshuk.computershop.model.command.ActionCommand;
import org.vironit.timoshuk.computershop.model.command.CommandEnum;
import org.vironit.timoshuk.computershop.model.command.common.EmptyCommand;
import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    public ActionCommand defineCommand (HttpServletRequest req) {
        ActionCommand command = new EmptyCommand();
        String action = req.getParameter("command");
        if (action == null || action.isEmpty()){
            return command;
        }
        try {
            CommandEnum commandEnum = CommandEnum.valueOf(action.toUpperCase());
            command = commandEnum.getCurrentCommand();
        }catch (IllegalArgumentException e){
            //TODO
        }
        return command;
    }
}
