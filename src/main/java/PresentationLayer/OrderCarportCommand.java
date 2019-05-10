package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

public class OrderCarportCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        
        String length = request.getParameter("length");
        HTMLSelect lengthSelect = new HTMLSelect("length",length," cm",240,810);
        
        String width = request.getParameter("width");
        HTMLSelect widthSelect = new HTMLSelect("width",width," cm",240,600);
        
        String shed = request.getParameter("shedInput");
        HTMLSelect shedSelect = new HTMLSelect("shedInput",shed," cm",150, 250);

        /* Set attributes for the chosen carport */
        request.setAttribute("lengthSelect", lengthSelect);
        request.setAttribute("widthSelect", widthSelect);
        request.setAttribute("shedSelect", shedSelect);
        return "shop";

    }
    
}
