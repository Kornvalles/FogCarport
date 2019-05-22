package PresentationLayer;

import FunctionLayer.Employee;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EmployeeCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) {
        try {
            HttpSession session = request.getSession();
            /* Get Parameters from the URL. (From the HTTP request) */
            String reqUsername = (String) request.getParameter("username");
            String reqPassword = (String) request.getParameter("password");
            Employee employee = logic.login(reqUsername, reqPassword);
            if (!employee.getPassword().equals(reqPassword)
                    && employee.getUsername().equals(reqUsername)) {
                session.setAttribute("employee", employee);
                return "login";
            }
        } catch (FogException ex) {
            request.setAttribute("error", ex);
        }
        return "employeePage";
    }
}
