/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DataLayer.UserMapper;
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
 * @author mikkel
 */
public class EmployeeCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        /* Get Parameters from the URL. (From the HTTP request) */
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");

        boolean valid = false;
        /* Check if User exists in the SQL database */
        if (!StringUtils.isNullOrEmpty(password)
                && !StringUtils.isNullOrEmpty(username)) { 
            /* check if user is valid */
            Employee employee = new UserMapper().getEmployee(username);
            if (password.equals(employee.getPassword())) {
                valid = true;
                HttpSession session = request.getSession();
                /* Put user on session */
                session.setAttribute("employee", employee);
            }
            return "employee";
        }

        if (valid == false) {
            /* If User is not in Database send him back to LoginPage */
            HttpSession session = request.getSession();
            session.setAttribute("errormessage", "You have entered an invalid username or password");
        }
        return "login";
    }
    
}
