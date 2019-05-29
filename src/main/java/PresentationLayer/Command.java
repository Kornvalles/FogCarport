package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

abstract class Command {
    
    /**
     * Initializes HashMap - commands.
     */

    private static HashMap<String, Command> commands;
    
    /**
     * Puts all commands in HashMap, and specifies each command with a key.
     */

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "CreateOrder", new CreateOrderCommand() );
        commands.put( "order", new SortimentCommand());
        commands.put( "invoice", new GetInvoiceCommand());
        commands.put( "Employee", new LoginCommand());
        commands.put( "logout" , new LogoutCommand());
        commands.put( "goBack", new GoBackCommand());
        commands.put( "updatePrice" , new ChangePriceCommand());
        commands.put( "createCustomer", new CreateCustomerCommand());
        commands.put( "deleteOrder", new DeleteOrderCommand());
        commands.put( "addEmployee", new AddEmployeeCommand());
        commands.put( "deleteEmployee", new DeleteEmployeeCommand());
        commands.put( "showEditEmployee", new ShowEditEmployeeCommand());
        commands.put( "editEmployee", new EditEmployeeCommand());
    }
    
    /**
     * 
     * @param request
     * @return returns the commandName to which the specified key is mapped, or UnknownCommand if this map contains no mapping for the key.
     */

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
