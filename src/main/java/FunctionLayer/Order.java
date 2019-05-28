package FunctionLayer;

/**
 *
 * @author mikkel
 */
public class Order {
    
    private final int id;
    private final int employeeId;
    private final int customerId;
    private final Carport carport;
    private final double totalPrice;

    /**
     *
     * @param id
     * @param employeeId
     * @param customerId
     * @param carport
     * @param totalPrice
     */
    public Order(int id, int employeeId, int customerId, Carport carport, double totalPrice) {
        this.id = id;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.carport = carport;
        this.totalPrice = totalPrice;
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
     * @return
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     *
     * @return
     */
    public int getCustomerId() {
        return customerId;
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
     * @return
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", employeeId=" + employeeId + ", customerId=" + customerId + ", carport=" + carport + ", totalPrice=" + totalPrice + '}';
    }
    
}
