package PresentationLayer;

import FunctionLayer.Calculator;
import FunctionLayer.Carport;
import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ibenk
 */
public class StandardOrder1Command extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        
        HttpSession session = request.getSession();
        
        int carportlength = 0;
        int carportWidth = 0;
        boolean carportShed = false;
        boolean carportRoof = false;
        int roofAngle = 0;
        boolean walls = false;
        
        
        Carport carport = new Carport(230, carportlength, carportWidth, carportShed, carportRoof, roofAngle, walls, "");
        
        //Fanger inputs fra jsp som ligger på requestet.
        String reqLength = request.setAttribute("length", carport);
        String reqWidth = request.setAttribute("width", carport);
        String reqShed = request.setAttribute("shed", carport);
        String reqRoof = request.setAttribute("roof", carport);
        String reqWall = request.setAttribute("wall", carport);
        String reqRoofAngle = request.setAttribute("roofAngle", carport);
        
        //Konveterer inputs som ikke skal være String.
        boolean shed = Boolean.parseBoolean(reqShed);
        boolean roof = Boolean.parseBoolean(reqRoof);
        boolean wall = Boolean.parseBoolean(reqWall);
        int length = Integer.parseInt(reqLength);
        int width = Integer.parseInt(reqWidth);
        int roofAngle = Integer.parseInt(reqRoofAngle);
        
        try {
            Carport carport = new Carport(230, length, width, shed, roof, roofAngle, wall, "");
            Construction construction = Calculator.constructCarport(carport, logic);
            session.setAttribute("construction", construction);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println(ex.getMessage());
        }
        //Sender en String tilbage til Frontcontrolleren om hvilken jsp side vi skal omdirigeres til.
        return "shop";
    }
    
}
