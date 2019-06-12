package PresentationLayer;

import FunctionLayer.Employee;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.PasswordHashing;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mikkel
 */
public class LoginCommand extends Command {
    
    /**
     * This method executes LoginCommand. 
     * The method checks and validates if username and password inputs appear in the database, for employee and admin logins.
     * 
     * @param request
     * @param logic
     * @return Returns either adminPage or employeePage. If username and password are wrong the servlet will return you to the login page.
     */
    @Override
    String execute(HttpServletRequest request, LogicFacade logic) {
        HttpSession session = request.getSession();
        PasswordHashing ph = new PasswordHashing();
        Employee employee = null;
        if (session.getAttribute("employee") == null || session.getAttribute("employee") == "") {
            try {
                /* Get Parameters from the URL. (From the HTTP request) */
                String reqUsername = (String) request.getParameter("username");
                String reqPassword = (String) request.getParameter("password");
                String hashedPassword = ph.makeHash(reqPassword);
                
                for (Employee e : logic.getAllEmployees()) {
                    if (e.getUsername().equals(reqUsername)) {
                        employee = logic.getEmployee(e.getId());
                    }
                }
                if (employee != null) {
                    if (!employee.getPassword().equals(hashedPassword) || !employee.getUsername().equals(reqUsername)) {
                        request.setAttribute("error", "Login mislykkedes, forkert brugernavn eller kodeord");
                        return "login";
                    } else {
                        session.setAttribute("employee", employee);
                        session.setAttribute("materials", logic.getAllMaterials());
                        session.setAttribute("orderlist", logic.getAllOrders());
                        session.setAttribute("employees", logic.getAllEmployees());
                        if (employee.isAdmin()) {
                            return "adminPage";
                        }
                    }
                } else {
                    request.setAttribute("error", "Login mislykkedes, forkert brugernavn eller kodeord");
                    return "login";
                }
            } catch (FogException ex) {
                request.setAttribute("error", ex);
            } catch (SQLException ex) {
                System.err.println(ex);
            }

        }
        return "employeePage";
    }
}
