package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Material;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//ikke færdig
public class ChangePriceCommand extends Command {
    
    /* Creating a Logger to log from catch clause when changing a price */
    private static final Logger logger = Logger.getLogger(ChangePriceCommand.class.getName());

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        HttpSession session = request.getSession();
        //Fanger inputs fra jsp som ligger på requestet.
        int id = 0;
        double newPrice = 0;
            try {
                for (Material m : logic.getAllMaterials()) {
                    if (request.getAttribute(m.getName()) != null) {
                        String reqId = request.getParameter(Integer.toString(m.getId()));
                        String reqNewPrice = request.getParameter(m.getName());
                        id = Integer.parseInt(reqId);
                        newPrice = Double.parseDouble(reqNewPrice);
                        System.out.print(id + " " + newPrice);
                    }
                    
                }
                logic.setMaterialPrice(id, newPrice);
                //session.setAttribute("materials", logic.getAllMaterials());
            } catch (SQLException ex) {
                System.err.print(ex.getMessage());
            }
        return "updateMaterialPrices";
    }

}
