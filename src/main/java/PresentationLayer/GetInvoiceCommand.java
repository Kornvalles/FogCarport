package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.Invoice;
import FunctionLayer.LogicFacade;
import com.itextpdf.layout.Document;
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
        return "InvoiceServlet";
    }
}
