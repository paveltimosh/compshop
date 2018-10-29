package org.vironit.timoshuk.computershop.command;

import org.vironit.timoshuk.computershop.command.common.*;
import org.vironit.timoshuk.computershop.command.item.ShowComputerInfoCommand;
import org.vironit.timoshuk.computershop.command.user.AddToCartCommand;
import org.vironit.timoshuk.computershop.command.user.UpdateUserDataCommand;

public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },REGISTER{
        {
            this.command = new RegisterCommand();
        }
    },CHANGE_USER_INFO{
        {
            this.command = new UpdateUserDataCommand();
        }
    },LOGOUT{
        {
            this.command = new LogoutCommand();
        }
    },SHOW_CATALOG_COMPUTER{
        {
            this.command = new ShowCatalogComputerCommand();
        }
    },
    SHOW_CATALOG_CASE{
        {
            this.command = new ShowCatalogCaseCommand();
        }
    },SHOW_COMPUTER_INFO{
        {
            this.command = new ShowComputerInfoCommand();
        }
    },ADD_TO_CART{
        {
            this.command = new AddToCartCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
