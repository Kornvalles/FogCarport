/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ndupo
 */
public class OrderCarportCommand extends Command{

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        
        String length = request.getParameter("length");
        HTMLSelect lengthSelect = new HTMLSelect("length",length," cm",240,720);
        /*int width = Integer.parseInt(request.getParameter("width"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        */
        
        request.setAttribute("lengthSelect", lengthSelect);
        return "shop";

    }
    
}
