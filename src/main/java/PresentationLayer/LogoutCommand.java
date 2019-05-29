package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mikkel
 */
public class LogoutCommand extends Command {
    
    /**
     * This method makes you Log out, of employee or admin user.
     * 
     * @param request
     * @param logic
     * @return Returns to index (Home page)
     * @throws FogException 
     */

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.setAttribute("message", "Du er nu succesfuldt logged ud!");
        return "index";
    }
    
}
