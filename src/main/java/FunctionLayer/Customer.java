package FunctionLayer;

/**
 *
 * @author mikkel
 */
public class Customer {
    
    private int id;
    private String name;
    private String email;
    private String address;
    private int zipcode;
    private int phoneNumber;

    /**
     *
     * @param id
     * @param name
     * @param email
     * @param address
     * @param zipcode
     * @param phoneNumber
     */
    public Customer(int id, String name, String email, String address, int zipcode, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String email, String address, int zipcode, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
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
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public int getZipcode() {
        return zipcode;
    }

    /**
     *
     * @param zipcode
     */
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    /**
     *
     * @return
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", zipcode=" + zipcode + ", phoneNumber=" + phoneNumber + '}';
    }

}
