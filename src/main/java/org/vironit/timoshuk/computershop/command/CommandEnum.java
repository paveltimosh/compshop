package org.vironit.timoshuk.computershop.command;

import org.vironit.timoshuk.computershop.command.common.LoginCommand;
import org.vironit.timoshuk.computershop.command.common.RegisterCommand;

public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    REGISTER{
        {
            this.command = new RegisterCommand();
        }
    };


    ActionCommand command;


    public ActionCommand getCurrentCommand() {
        return command;
    }
}
