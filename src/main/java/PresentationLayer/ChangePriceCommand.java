package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//ikke færdig

/**
 *
 * @author mikkel
 */
public class ChangePriceCommand extends Command {
    
    /* Creating a Logger to log from catch clause when changing a price */
    private static final Logger logger = Logger.getLogger(ChangePriceCommand.class.getName());
    
    /**
     * 
     * 
     * @param request - catches inputs from jsp.
     * @param logic
     * @return returns to updatetMaterialPrices.jsp, when a material price has been changed.
     * @throws FogException 
     */

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        HttpSession session = request.getSession();
        //Catch inputs from jsp, which is on the request.
        double newPrice = 0;
        if (!"".equals(request.getParameter("newPrice"))) {
            newPrice = Double.parseDouble(request.getParameter("newPrice"));
        } else if (!"".equals(request.getParameter("newCostPrice"))) {
            newPrice = Double.parseDouble(request.getParameter("newCostPrice"));
        } else {
            request.setAttribute("errorMessage", "Fejlede at ændre prisen på materialet");
            return "updateMaterialPrices";
        }
        int id = Integer.parseInt(request.getParameter("materialId"));
            try {
                if (!"".equals(request.getParameter("newPrice"))) {
                    logic.setMaterialPrice(id, newPrice);
                } else {
                    logic.setMaterialCostPrice(id, newPrice);
                }
                session.setAttribute("materials", logic.getAllMaterials());
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, ex.getMessage());
            }
        return "updateMaterialPrices";
    }

}
