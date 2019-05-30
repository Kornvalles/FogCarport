package PresentationLayer;

import FunctionLayer.Customer;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mikkel
 */
public class CreateCustomerCommand extends Command {

    /**
     * Creating a Logger to log from catch clause when creating order.
     */
    
    private static final Logger logger = Logger.getLogger(CreateOrderCommand.class.getName());
    
    /**
     * 
     * @param request
     * @param logic
     * @return returns to shop.jsp when customers inputs are validatet and put into database.
     * @throws FogException 
     */

    @Override
    String execute(HttpServletRequest request, LogicFacade logic) throws FogException {

        HttpSession session = request.getSession();
        Validate validate = new Validate();

        /* Gets input from parameter and validates input */
        String name = validate.validateString(request.getParameter("name"), "Navn");
        String email = validate.validateString(request.getParameter("email"), "Email");
        String address = validate.validateString(request.getParameter("address"), "Adresse");
        int zip = validate.validateInteger(request.getParameter("zipcode"), "Postnummer");
        int phone = validate.validateInteger(request.getParameter("telephone"), "Telefonnummer");
        
        HTMLSelect lengthSelect = null;
        HTMLSelect widthSelect = null;
        HTMLSelect shedSelect = null;
        String hasShed = null;
        String hasPointyRoof = null;
        if (request.getAttribute("lengthSelect") != null) {
            lengthSelect = (HTMLSelect) request.getAttribute("lengthSelect");
        } else {
            request.setAttribute("lengthSelect", new HTMLSelect("length","240"," cm",240,810));
        }
        if (request.getAttribute("widthSelect") != null) {
            widthSelect = (HTMLSelect) request.getAttribute("widthSelect");
        } else {
            request.setAttribute("widthSelect", new HTMLSelect("width","240"," cm",240,600));
        }
        if (request.getAttribute("shedSelect") != null) {
            shedSelect = (HTMLSelect) session.getAttribute("shedSelect");
        } else {
            request.setAttribute("shedSelect", new HTMLSelect("shedLength","150"," cm",150, 250));
        }
        if (request.getAttribute("hasShed") != null) {
            hasShed = (String) request.getAttribute("hasShed");
        } else {
            hasShed = "checked='unchecked'";
        }
        if (request.getAttribute("hasPointyRoof") != null) {
            hasPointyRoof = (String) request.getAttribute("hasPointyRoof");
        } else {
            hasPointyRoof = "checked='unchecked'";
        }
        
        for (Customer c : logic.getAllCustomers()) {
            if (c.getEmail().equals(email)) {
                session.setAttribute("customer", c);
                return "shop";
            }
        }

        //Initializes objects and puts them on session.
        //Runs logic. Tries to put inputs in database.
        try {
            Customer customer = logic.addCustomer(name, email, address, zip, phone);
            session.setAttribute("customer", customer);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating customer.", e);
            throw new FogException(e.getMessage());
        }

        return "shop";
    }

}
