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
        
        HTMLSelect lengthSelect = new HTMLSelect("length", "240", " cm", 240, 810);
        HTMLSelect widthSelect = new HTMLSelect("width", "240", " cm", 240, 600);
        HTMLSelect shedSelect = new HTMLSelect("shedLength", "150", " cm", 150, 250);
        request.setAttribute("lengthSelect", lengthSelect);
        request.setAttribute("widthSelect", widthSelect);
        request.setAttribute("shedSelect", shedSelect);
        
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
