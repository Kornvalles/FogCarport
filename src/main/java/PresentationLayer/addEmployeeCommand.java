package PresentationLayer;

import FunctionLayer.Employee;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class addEmployeeCommand extends Command {

    private static final Logger logger = Logger.getLogger(CreateOrderCommand.class.getName());

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        boolean isAdmin = true;
        if (!"on".equals(request.getParameter("isAdmin"))) {
            isAdmin = false;
        }
        try {
            logic.addEmployee(new Employee(username, password, isAdmin));
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return "adminPage";
    }

}
