package PresentationLayer;

import FunctionLayer.Employee;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mikkel
 * 
 */
public class AddEmployeeCommand extends Command {

    private static final Logger logger = Logger.getLogger(CreateOrderCommand.class.getName());
    
    /**
     * String execute HttpServletRequest
     * 
     * @param request - gets the parameter of admins username and password.
     * @param logic
     * @return returns to adminPage.jsp when admin succesfully has added an Employee. 
     * @throws FogException 
     */

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        boolean isAdmin = true;
        // If switch is off, then we set isAdmin to false.
        if (!"on".equals(request.getParameter("isAdmin"))) {
            isAdmin = false;
        }
        try {
            logic.addEmployee(new Employee(username, password, isAdmin));
            request.setAttribute("message", "Medarbejder " + username + " er blevet oprettet");
            session.setAttribute("employees", logic.getAllEmployees());
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return "adminPage";
    }

}
