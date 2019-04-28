package PresentationLayer;


import FunctionLayer.Carport;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mikkel
 */
public class Order extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String origin = (String) request.getParameter("origin");
        String view = "";
        switch (origin) {
            case "createOrder": {
                view = createOrder(request);
                break;
            }
        }
        return view;
    }

    private String createOrder(HttpServletRequest request) throws FogException {
        
        HttpSession session = request.getSession();
        
        String reqLength = request.getParameter("length");
        String reqWidth = request.getParameter("width");
        boolean shed;
        boolean roof;
        boolean wall;
            String reqShed = request.getParameter("shed");
            shed = Boolean.parseBoolean(reqShed);  
            String reqRoof = request.getParameter("roof");
             roof = Boolean.parseBoolean(reqRoof);
            String reqWall = request.getParameter("wall");
             wall = Boolean.parseBoolean(reqWall);
        String reqName = request.getParameter("name");
        String reqEmail = request.getParameter("email");
        int length = Integer.parseInt(reqLength);
        int width = Integer.parseInt(reqWidth);
        Carport carport = new Carport(230, length, width, shed, roof, wall, "");
        session.setAttribute("carport", carport);
//        LogicFacade.createOrder(carport, reqName, reqEmail);
        
       
        return "confirmation";
    }

}
