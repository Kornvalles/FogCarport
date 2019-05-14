package PresentationLayer;

import FunctionLayer.FogException;

public class Validate {

    /**
    * Validates the String-input. A String cannot be empty.
    */
    public String validateString(String input, String name) throws FogException {

        if (input == null || input.isEmpty()) {
            throw new FogException(name + " må ikke være tom.");
        }
        return input;
    }

    /**
    * Validates the integer-input. Only integers are allowed as input.
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
