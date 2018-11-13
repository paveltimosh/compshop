package org.vironit.timoshuk.computershop.command;

import org.vironit.timoshuk.computershop.command.common.*;
import org.vironit.timoshuk.computershop.command.item.ShowComputerInfoCommand;
import org.vironit.timoshuk.computershop.command.user.*;

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
    },SHOW_CATALOG_CPU{
        {
            this.command = new ShowCatalogCpuCommand();
        }
    },ADD_TO_CART{
        {
            this.command = new AddToCartCommand();
        }
    },DELETE_FROM_CART{
        {
            this.command = new DeleteFromCartCommand();
        }
    },SHOW_CATALOG_MOTHER_BOARD{
        {
            this.command = new ShowCatalogMotherBoardCommand();
        }
    },SHOW_CATALOG_RAM{
        {
            this.command = new ShowCatalogRamCommand();
        }
    },SHOW_CATALOG_VIDEO_CARD{
        {
            this.command = new ShowCatalogVideocardCommand();
        }
    },MAKE_ORDER{
        {
            this.command = new MakeOrderCommand();
        }
    },SHOW_ORDERS_OF_USER{
        {
            this.command = new ShowOrderUserCommand();
        }
    },CONFIRM_ORDER{
        {
            this.command = new ConfirmOrderCommand();
        }
    },DELETE_ORDER_USER{
        {
            this.command = new DeleteOrderByUserCommand();
        }
    }
    ;

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
