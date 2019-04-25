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
public class Screws extends Materials {
    
    private int qty;
    private double price;

    public Screws(int qty, double price) {
        this.qty = qty;
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Screws{" + "qty=" + qty + ", price=" + price + '}';
    }
    
    
}
