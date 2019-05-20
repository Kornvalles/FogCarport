package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
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
        String reqMSRP1 = request.getParameter("MSRP1");
        String reqMSRP2 = request.getParameter("MSRP2");
        String reqMSRP3 = request.getParameter("MSRP3");
        String reqMSRP4 = request.getParameter("MSRP4");
        String reqMSRP5 = request.getParameter("MSRP5");
        String reqMSRP6 = request.getParameter("MSRP6");
        String reqMSRP7 = request.getParameter("MSRP7");
        String reqKP1 = request.getParameter("KP1");
        String reqKP2 = request.getParameter("KP2");
        String reqKP3 = request.getParameter("KP3");
        String reqKP4 = request.getParameter("KP4");
        String reqKP5 = request.getParameter("KP5");
        String reqKP6 = request.getParameter("KP6");
        String reqKP7 = request.getParameter("KP7");
        return null;
        
        

//TODO få det her til at virke sammen med submit knapperne i jsp side + 
        
    }
        
}
