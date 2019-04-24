/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author mikkel
 */
public class Carport {
    
    private final int height; //measured in centimeters.
    private final int length; //measured in centimeters.
    private final boolean toolshed; //false when toolshed is not opted
    private final String details; //details on carport

    public Carport(int height, int length, boolean toolshed, String details) {
        this.height = height;
        this.length = length;
        this.toolshed = toolshed;
        this.details = details;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public boolean hasToolshed() {
        return toolshed;
    }

    @Override
    public String toString() {
        return "Carport: " + "height = " + height + ", length = " + length + ", toolshed = " + toolshed;
    }
    
}
