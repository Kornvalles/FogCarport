package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

public class EditEmployeeCommand extends Command {
    
    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        String username = request.getParameter("usernameEdit");
        String password = request.getParameter("pwdEdit");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isAdmin = true;
        // If switch is off, then we set isAdmin to false.
        if (!"on".equals(request.getParameter("isAdmin"))) {
            isAdmin = false;
        }
        logic.setEmployee(id, username, password, isAdmin);
        request.setAttribute("message", "Medarbejder " + username + " er blevet ændret");
        return "adminPage";
    }
    
}
