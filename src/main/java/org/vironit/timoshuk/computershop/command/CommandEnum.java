package org.vironit.timoshuk.computershop.command;

import org.vironit.timoshuk.computershop.command.common.LoginCommand;
import org.vironit.timoshuk.computershop.command.common.RegisterCommand;
import org.vironit.timoshuk.computershop.command.user.UpdateUserDataCommand;

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
    },CHANGE_USER_INFO{
        {
            this.command = new UpdateUserDataCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
