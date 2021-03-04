package by.jwd.restaurant.controller.command;

import by.jwd.restaurant.controller.command.impl.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(CommandName.LOGINATION, new Logination());
        commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
    }

    public Command takeCommand(String name){
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }
}
