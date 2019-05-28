package FunctionLayer;

import java.util.List;

/**
 *
 * @author mikkel
 */
public class Construction {
    
    private Carport carport;
    private List<Material> materials;
    private double totalPrice;

    /**
     *
     * @param carport
     * @param materials
     * @param totalPrice
     */
    public Construction(Carport carport, List<Material> materials, double totalPrice) {
        this.carport = carport;
        this.materials = materials;
        this.totalPrice = totalPrice;
    }

    /**
     *
     * @return
     */
    public Carport getCarport() {
        return carport;
    }

    /**
     *
     * @param carport
     */
    public void setCarport(Carport carport) {
        this.carport = carport;
    }

    /**
     *
     * @return
     */
    public List<Material> getMaterials() {
        return materials;
    }

    /**
     *
     * @param materials
     */
    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    /**
     *
     * @return
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     *
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    
}
