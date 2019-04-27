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
public class Roof extends Materials {
    
    private int price; //added price
    private boolean tall; //if roof is tall or not
    private boolean rooftype; //which rooftype it is !!REVISIT THIS!! name is terrible

    //constructor
    public Roof(int price, boolean tall, boolean rooftype) {
        this.price = price;
        this.tall = tall;
        this.rooftype = rooftype;
    }
//getters and setters
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isTall() {
        return tall;
    }

    public void setTall(boolean tall) {
        this.tall = tall;
    }

    public boolean isRooftype() {
        return rooftype;
    }

    public void setRooftype(boolean rooftype) {
        this.rooftype = rooftype;
    }
//tostring
    @Override
    public String toString() {
        return "Roof{" + "price=" + price + ", tall=" + tall + ", rooftype=" + rooftype + '}';
    }
    
    
}
