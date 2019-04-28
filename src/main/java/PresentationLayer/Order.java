package PresentationLayer;


import FunctionLayer.FogException;
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

    private String createOrder(HttpServletRequest request) {
        
        
        String reqLength = request.getParameter("length");
        String reqWidth = request.getParameter("width");
        boolean shed = false;
        boolean roof = false;
        boolean wall = false;
        
        if (!request.getParameter("shed").isEmpty()) {
            String reqShed = request.getParameter("shed");
            shed = Boolean.parseBoolean(reqShed);  
        }
        if (!request.getParameter("roof").isEmpty()) {
            String reqRoof = request.getParameter("roof");
             roof = Boolean.parseBoolean(reqRoof);
        }
        if (!request.getParameter("wall").isEmpty()) {
            String reqWall = request.getParameter("wall");
             wall = Boolean.parseBoolean(reqWall);
        }
        String reqName = request.getParameter("name");
        String reqEmail = request.getParameter("email");
        int length = Integer.parseInt(reqLength);
        int width = Integer.parseInt(reqWidth);
        
        
       
        return null;
    }

}
