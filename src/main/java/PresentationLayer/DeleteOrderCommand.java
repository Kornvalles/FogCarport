/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Benjamin
 */
public class DeleteOrderCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {

        logic.deleteOrder(Integer.parseInt(request.getParameter("orderid")));
        return "viewAllOrders";
    }
}
