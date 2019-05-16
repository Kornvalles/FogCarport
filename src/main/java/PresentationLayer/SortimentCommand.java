package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

public class SortimentCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        
        String length = request.getParameter("length");
        HTMLSelect lengthSelect = new HTMLSelect("length",length," cm",240,810);
        
        String width = request.getParameter("width");
        HTMLSelect widthSelect = new HTMLSelect("width",width," cm",240,600);
        
        String shedLength = request.getParameter("shedLength");
        HTMLSelect shedSelect = new HTMLSelect("shedLength",shedLength," cm",150, 250);
        
        String hasShed = request.getParameter("hasShed");
        if ("true".equals(hasShed)) request.setAttribute("shedChecked", "checked='checked'");
        
        String hasPointyRoof = request.getParameter("hasPointyRoof");
        if ("true".equals(hasPointyRoof)) request.setAttribute("roofChecked", "checked='checked'");

        /* Set attributes for the chosen carport */
        request.setAttribute("lengthSelect", lengthSelect);
        request.setAttribute("widthSelect", widthSelect);
        request.setAttribute("shedSelect", shedSelect);

        return "shop";

    }
    
}
