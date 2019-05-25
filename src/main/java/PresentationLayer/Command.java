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
        commands.put( "order", new SortimentCommand());
        commands.put( "invoice", new GetInvoiceCommand());
        commands.put( "Employee", new LoginCommand());
        commands.put( "logout" , new LogoutCommand());
        commands.put( "goBack", new goBackCommand());
        commands.put( "updatePrice" , new ChangePriceCommand());
        commands.put( "createCustomer", new CreateCustomerCommand());
        commands.put( "deleteOrder", new DeleteOrderCommand());
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
