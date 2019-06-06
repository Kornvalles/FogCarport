package PresentationLayer;

import FunctionLayer.Employee;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
        int id = (Integer.parseInt(request.getParameter("id")));
        for (Employee e : logic.getAllEmployees()) {
            if (e.getId() == id) {
                logic.deleteEmployee(id);
                request.setAttribute("message", "Medarbejder " + id + " er blevet slettet!");
                session.setAttribute("employees", logic.getAllEmployees());
            }
            request.setAttribute("errorMessage", "Der findes ingen medarbejder med id: " + id + ". Se alle medarbejder for at få id");
        }
        return "adminPage";    
    }
    
}
