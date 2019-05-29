package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteOrderCommand extends Command {
    
    private static final Logger logger = Logger.getLogger(ChangePriceCommand.class.getName());

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        HttpSession session = request.getSession();
        logic.deleteOrder(Integer.parseInt(request.getParameter("orderid")));
        try {
            session.setAttribute("orderlist", logic.getAllOrders());
        } catch (SQLException ex) {
            logger.getLogger(DeleteOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "viewAllOrders";
    }
}
