package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "CreateOrder", new CreateOrderCommand() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, LogicFacade logic ) 
            throws FogException; //Der skal laves en custom exception.

}
