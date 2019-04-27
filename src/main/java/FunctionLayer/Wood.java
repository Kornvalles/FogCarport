/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author benjaminbajrami
 */
public class Wood extends Materials{
    
    private int length; //length of board   
    private int width; //width of board
    private double price; 
    private int qty; //amount of boards

    public Wood(int length, int width, double price, int qty) { //constructor
        this.length = length;
        this.width = width;
        this.price = price;
        this.qty = qty;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Wood{" + "length=" + length + ", width=" + width + ", price=" + price + ", qty=" + qty + '}';
    }
    
    
}

    
    
