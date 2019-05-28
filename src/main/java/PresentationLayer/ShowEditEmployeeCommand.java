package PresentationLayer;

import FunctionLayer.Employee;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mikkel
 */
public class ShowEditEmployeeCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        request.setAttribute("employeeToEdit", (Employee) logic.getEmployee(Integer.getInteger(request.getParameter("employeeId"))));
        return "adminPage";
    }
    
}
