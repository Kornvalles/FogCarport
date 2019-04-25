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
            case "ShowOrders": {
                view = ShowOrders(request);
                break;
            }
        }
        return view;
    }

    private String ShowOrders(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return null;
    }
        
}
