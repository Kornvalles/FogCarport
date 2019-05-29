package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mikkel
 */
public class DeleteEmployeeCommand extends Command {
    
    /**
     * 
     * @param request
     * @param logic
     * @return when an employee has been deletet, it will redirect to adminPage.jsp.
     * @throws FogException 
     */

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        int id = (Integer.parseInt(request.getParameter("id")));
        logic.deleteEmployee(id);
        request.setAttribute("message", "Medarbejder " + id + " er blevet slettet!");
        return "adminPage";    
    }
    
}
