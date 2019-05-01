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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mikkel
 */
public class CreateOrderCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        
        HttpSession session = request.getSession();
        
        //Fanger inputs fra jsp som ligger på requestet.
        String reqLength = request.getParameter("length");
        String reqWidth = request.getParameter("width");
        String reqShed = request.getParameter("shed");
        String reqRoof = request.getParameter("roof");
        String reqWall = request.getParameter("wall");
        String reqName = request.getParameter("name");
        String reqEmail = request.getParameter("email");
        
        //Konveterer inputs som ikke skal være String.
        boolean shed = Boolean.parseBoolean(reqShed);
        boolean roof = Boolean.parseBoolean(reqRoof);
        boolean wall = Boolean.parseBoolean(reqWall);
        int length = Integer.parseInt(reqLength);
        int width = Integer.parseInt(reqWidth);
        
        //Instancerer objekter og putter dem på session
        Customer customer = new Customer(reqName, reqEmail, "", 2800, "");
        Carport carport = new Carport(230, length, width, shed, roof, wall, "");
        Construction construction = Calculator.constructCarport(carport, logic);
        session.setAttribute("construction", construction);
        session.setAttribute("customer", customer);
        
        //Kører logikken. Forsøger at putte ting i database.
        try {
            logic.addCustomer(customer);
            logic.createOrder(carport, customer);
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
            System.out.println(ex.getMessage());
        }
        
        //Sender en String tilbage til Frontcontrolleren om hvilken jsp side vi skal omdirigeres til.
        return "confirmation";
    }
}
