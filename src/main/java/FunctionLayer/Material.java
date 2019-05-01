package FunctionLayer;

/**
 *
 * @author ibenk
 */
public class Material {
    
    private String name;
    private int qty;
    private String unit;
    private double price;
    private double totalprice;

    public Material(String name, int qty, String unit, double price) {
        this.name = name;
        this.qty = qty;
        this.unit = unit;
        this.price = price;
        this.totalprice = qty*price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalprice() {
        return price*qty;
    }
    
    

    @Override
    public String toString() {
        return "\nMaterial: " + name + 
                ", amount: " + qty + " " + unit + 
                ", price pr. unit: " + String.format("%.2f", price) + 
                ", total item price: " + String.format("%.2f", totalprice);
    }
    
    
    
}
