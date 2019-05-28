package FunctionLayer;

public class Order {
    
    private final int id;
    private final int employeeId;
    private final int customerId;
    private final Carport carport;
    private final double totalPrice;

    public Order(int id, int employeeId, int customerId, Carport carport, double totalPrice) {
        this.id = id;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.carport = carport;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Carport getCarport() {
        return carport;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", employeeId=" + employeeId + ", customerId=" + customerId + ", carport=" + carport + ", totalPrice=" + totalPrice + '}';
    }
    
}
