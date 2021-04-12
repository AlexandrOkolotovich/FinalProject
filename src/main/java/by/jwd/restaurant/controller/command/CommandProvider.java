package by.jwd.restaurant.controller.command;

import by.jwd.restaurant.controller.command.impl.*;
import by.jwd.restaurant.controller.command.impl.go.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(CommandName.GOTOLOGINPAGE, new GoToLogInPage());
        commands.put(CommandName.GOTOHOMEPAGE, new GoToHomePage());
        commands.put(CommandName.GOTOADDDISHPAGE, new GoToAddDishPage());
        commands.put(CommandName.GOTOMENUPAGE, new GoToMenuPage());
        commands.put(CommandName.GOTOEDITDISHPAGE, new GoToEditDishPage());
        commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
        commands.put(CommandName.LOGIN, new LogIn());
        commands.put(CommandName.LOGOUT, new LogOut());
        commands.put(CommandName.SAVENEWUSER, new Registration());
        commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
        commands.put(CommandName.EN, new ChangeLocale());
        commands.put(CommandName.RU, new ChangeLocale());
        commands.put(CommandName.ADDNEWDISH, new AddNewDish());
        commands.put(CommandName.MAKEORDER, new MakeOrder());
        commands.put(CommandName.ADDTOORDER, new AddToOrder());
        commands.put(CommandName.DELETEDISH, new DeleteDish());
        commands.put(CommandName.UPDATEDISH, new UpdateDish());
    }

    public Command takeCommand(String name){
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }
}
