package PresentationLayer;

import FunctionLayer.FogException;

/**
 *
 * @author mikkel
 */
public class Validate {

    /**
    * Validates the String-input. A String cannot be empty.
     * @param input
     * @param name
     * @return 
     * @throws FunctionLayer.FogException 
    */
    public String validateString(String input, String name) throws FogException {

        if (input == null || input.isEmpty()) {
            throw new FogException(name + " må ikke være tom.");
        }
        return input;
    }

    /**
    * Validates the integer-input. Only integers are allowed as input.
     * @param input
     * @param name
     * @return 
     * @throws FunctionLayer.FogException
    */
    public int validateInteger(String input, String name) throws FogException {

        if (input == null || input.isEmpty()) {
            throw new FogException(name + " må ikke være tom.");
        } 
        
        try {
            int validate = Integer.parseInt(input);
            return validate;
        } catch (NumberFormatException e) {
            throw new FogException(name + " må kun være tal.");
        }
    }
    
}
