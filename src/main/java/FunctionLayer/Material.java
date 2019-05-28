package FunctionLayer;

/**
 *
 * @author mikkel
 */
public class Material {
    
    private String name;
    private int id;
    private int qty;
    private String unit;
    private double price;
    private double costPrice;
    private double totalprice;
    private String description;

    /**
     *
     * @param name
     * @param id
     * @param qty
     * @param unit
     * @param price
     * @param costPrice
     * @param description
     */
    public Material(String name, int id, int qty, String unit, double price, double costPrice, String description) {
        this.name = name;
        this.id = id;
        this.qty = qty;
        this.unit = unit;
        this.price = price;
        this.costPrice = costPrice;
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }
    
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getQty() {
        return qty;
    }

    /**
     *
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     *
     * @return
     */
    public String getUnit() {
        return unit;
    }

    /**
     *
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public double getTotalprice() {
        return totalprice;
    }

    /**
     *
     * @param totalprice
     */
    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    /**
     *
     * @return
     */
    public double getCostPrice() {
        return costPrice;
    }

    /**
     *
     * @param costPrice
     */
    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
    
    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\nMaterial: " + name + 
                ", amount: " + qty + " " + unit + 
                ", price pr. unit: " + String.format("%.2f", price) + 
                ", total item price: " + String.format("%.2f", totalprice);
    }
    
    
    
}
