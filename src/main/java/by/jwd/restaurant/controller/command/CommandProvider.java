package by.jwd.restaurant.controller.command;

import by.jwd.restaurant.controller.command.impl.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(CommandName.GOTOLOGINPAGE, new GoToLogInPage());
        commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
        commands.put(CommandName.LOGIN, new LogIn());
        commands.put(CommandName.LOGOUT, new LogOut());
        commands.put(CommandName.SAVENEWUSER, new Registration());
        commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
    }

    public Command takeCommand(String name){
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }
}
