package PresentationLayer;

import FunctionLayer.Calculator;
import FunctionLayer.Carport;
import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateOrderCommand extends Command {
    
    /* Creating a Logger to log from catch clause when creating order */
    private static final Logger logger = Logger.getLogger(CreateOrderCommand.class.getName());
    
    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {

        HttpSession session = request.getSession();
        
        //Fanger inputs fra jsp som ligger på requestet.
        String reqLength = request.getParameter("length");
        String reqWidth = request.getParameter("width");
        String reqShed = request.getParameter("shed");
        String reqShedWidth = request.getParameter("shedWidth");
        String reqRoof = request.getParameter("roof");
        String reqRoofType = request.getParameter("roofType");
        String reqWall = request.getParameter("wall");
        String reqRoofAngle = request.getParameter("roofAngle");
        
        //Konveterer inputs som ikke skal være String.
        boolean toolShed = Boolean.parseBoolean(reqShed);
        boolean roof = Boolean.parseBoolean(reqRoof);
        boolean roofType = Boolean.parseBoolean(reqRoofType);
        boolean wall = Boolean.parseBoolean(reqWall);
        int shedWidth = Integer.parseInt(reqShedWidth);
        int length = Integer.parseInt(reqLength);
        int width = Integer.parseInt(reqWidth);
        int roofAngle = Integer.parseInt(reqRoofAngle);

        try {
            Carport carport = new Carport(230, length, width, toolShed, shedWidth, roof, roofType, roofAngle, wall, "");
            Customer customer = (Customer) session.getAttribute("customer");
            
            Construction construction = Calculator.constructCarport(carport, logic);
            session.setAttribute("construction", construction);
            
            logic.createOrder(construction, customer);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating a carport order.", e);
            throw new FogException(e.getMessage());
        }

        //Sender en String tilbage til Frontcontrolleren om hvilken jsp side vi skal omdirigeres til.
        return "confirmation";
    }
}
