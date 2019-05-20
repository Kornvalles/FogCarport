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
public class goBackCommand extends Command {

    public goBackCommand() {
    }

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
         return "employeePage";
    }
    
}
