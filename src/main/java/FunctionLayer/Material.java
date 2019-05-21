package FunctionLayer;

public class Material {
    
    private String name;
    private int id;
    private int qty;
    private String unit;
    private double price;
    private double costPrice;
    private double totalprice;
    private String description;

    public Material(String name, int id, int qty, String unit, double price, double costPrice, String description) {
        this.name = name;
        this.id = id;
        this.qty = qty;
        this.unit = unit;
        this.price = price;
        this.costPrice = costPrice;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
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
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
    
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
