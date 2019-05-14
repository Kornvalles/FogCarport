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
        HttpSession session = request.getSession();
        /* Get Parameters from the URL. (From the HTTP request) */
        String reqUsername = (String) request.getParameter("username");
        String reqPassword = (String) request.getParameter("password");
        
        boolean valid = false;
        if (!StringUtils.isNullOrEmpty(reqPassword)
                && !StringUtils.isNullOrEmpty(reqUsername)) {
        try {
            Employee employee = new UserMapper().getEmployee(reqUsername);
            if(reqPassword.equals(employee.getPassword())) {
                valid = true;
            session.setAttribute("employee", employee);
            logic.getEmployee(employee);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println(ex.getMessage());
        }
        if (valid == false) {
            /* If User is not in Database send him back to LoginPage */
            session.setAttribute("errormessage", "You have entered an invalid username or password");
            return "login";
        }
        }
        return "employeePage";

    }
}
