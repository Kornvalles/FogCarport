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

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        int id = (Integer.parseInt(request.getParameter("id")));
        logic.deleteEmployee(id);
        request.setAttribute("message", "Medarbejder " + id + " er blevet slettet!");
        return "adminPage";    
    }
    
}
