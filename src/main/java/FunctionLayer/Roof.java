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
    
    private int price;
    private boolean tall;
    private boolean rooftype;

    public Roof(int price, boolean tall, boolean rooftype) {
        this.price = price;
        this.tall = tall;
        this.rooftype = rooftype;
    }

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

    @Override
    public String toString() {
        return "Roof{" + "price=" + price + ", tall=" + tall + ", rooftype=" + rooftype + '}';
    }
    
    
}
