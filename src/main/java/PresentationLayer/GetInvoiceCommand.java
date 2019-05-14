package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.Invoice;
import FunctionLayer.LogicFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            Invoice invoice = logic.makeInvoice(customer, construction);
            session.setAttribute("invoice", invoice);
        } catch (IOException ex) {
            Logger.getLogger(GetInvoiceCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "invoicePdf";
    }
    
}
