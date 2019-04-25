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
    
    //private final int height; //measured in centimeters.
    //private final int length; //measured in centimeters.
    private final int id;
    private final boolean toolshed; //false when toolshed is not opted
    private final String details; //details on carport
    private final int price; //price of carport

    public Carport(int id, boolean toolshed, String details, int price) {
        //this.height = height;
        //this.length = length;
        this.id = id;
        this.toolshed = toolshed;
        this.details = details;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

//    public int getHeight() {
//        return height;
//    }

    public String getDetails() {
        return details;
    }

//    public int getLength() {
//        return length;
//    }

    public boolean hasToolshed() {
        return toolshed;
    }

    @Override
    public String toString() {
        return "Carport{" + "toolshed=" + toolshed + ", details=" + details + ", price=" + price + '}';
    }

    public int getPrice() {
        return price;
    }
    
}
