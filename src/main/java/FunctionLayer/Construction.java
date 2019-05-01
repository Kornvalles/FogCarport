/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author ibenk
 */
public class Construction {
    
    private Carport carport;
    private List<Material> materials;
    private double totalPrice;

    public Construction(Carport carport, List<Material> materials, double totalPrice) {
        this.carport = carport;
        this.materials = materials;
        this.totalPrice = totalPrice;
    }

    public Carport getCarport() {
        return carport;
    }

    public void setCarport(Carport carport) {
        this.carport = carport;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    //return stringformat
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    
}
