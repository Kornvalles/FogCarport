/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author ndupo
 */
public class Shed {

    private final int length; //measured in centimeters.
    private final int width; //measured in centimeters.
    private final boolean door;

    public Shed(int length, int width, boolean door) {
        this.length = length;
        this.width = width;
        this.door = door;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public boolean isDoor() {
        return door;
    }

    @Override
    public String toString() {
        return "Shed{" + "length=" + length 
                + ", width=" + width 
                + ", door=" + door + '}';
    }
    
}
