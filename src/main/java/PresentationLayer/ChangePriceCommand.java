package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Material;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//ikke færdig
public class ChangePriceCommand extends Command {

    /* Creating a Logger to log from catch clause when changing a price */
    private static final Logger logger = Logger.getLogger(ChangePriceCommand.class.getName());

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        
        //Fanger inputs fra jsp som ligger på requestet.
        String reqId = request.getParameter("id");
        int id = Integer.parseInt(reqId);
        double newPrice = 0;
        try {
            for (Material m : logic.getAllMaterials()) {
                if (request.getParameter(m.getName()) != null) {
                    String reqNewPrice = request.getParameter(m.getName());
                    newPrice = Double.parseDouble(reqNewPrice);
                    if (m.getId() == id)
                    logic.setMaterialPrice(id, newPrice);
                    request.setAttribute("message", "Prisen for " + m.getName() + "er ændret til " + newPrice);
                }
                System.err.println("Id findes ikke");
            }
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }

        return "updateMaterialPrices";
    }

}
