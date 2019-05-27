package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

public class GoBackCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
         return "employeePage";
    }
}
