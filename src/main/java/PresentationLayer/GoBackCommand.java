package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mikkel
 */
public class GoBackCommand extends Command {
    
    /**
     * 
     * @param request
     * @param logic
     * @return employeePage.jsp
     * @throws FogException 
     */

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
         return "employeePage";
    }
}
