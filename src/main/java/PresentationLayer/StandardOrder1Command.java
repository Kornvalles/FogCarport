package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ibenk
 */
public class StandardOrder1Command extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
