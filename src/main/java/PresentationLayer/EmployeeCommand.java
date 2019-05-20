/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.UserMapper;
import FunctionLayer.Employee;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import com.mysql.cj.util.StringUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicklas og Benjamin
 */
public class EmployeeCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        try {
            HttpSession session = request.getSession();
            /* Get Parameters from the URL. (From the HTTP request) */
            String reqUsername = (String) request.getParameter("username");
            String reqPassword = (String) request.getParameter("password");
            Employee employee = logic.login(reqUsername, reqPassword);
            session.setAttribute("employee", employee);
            session.setAttribute("materials", logic.getAllMaterials());
            if (!employee.getPassword().equals(reqPassword)
                    && employee.getUsername().equals(reqUsername)) {
                return "login";
            }
        } catch (SQLException ex) {
            request.setAttribute("error", ex);
        }
        return "employeePage";
    }
}
