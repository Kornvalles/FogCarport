/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Calculator;
import FunctionLayer.Carport;
import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Shed;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Benjamin
 */
public class Login extends Command {
    
    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {

        HttpSession session = request.getSession();
        
          String reqUsername = request.getParameter("username");
          String reqPassword = request.getParameter("password");
        
        
}
