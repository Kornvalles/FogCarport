package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mikkel
 */
public class GetInvoiceCommand extends Command {

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {
        HttpSession session = request.getSession();
        Construction construction = (Construction) session.getAttribute("construction");
        Customer customer = (Customer) session.getAttribute("customer");
        logic.makeInvoice(customer, construction);
        return "confirmation";
    }
    
}
