package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class DeleteEmployeeCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        String username = request.getParameter("username");
        logic.deleteEmployee(username);
        request.setAttribute("message", "Medarbejder " + username + " er blevet slettet!");
        return "adminPage";    
    }
    
}
