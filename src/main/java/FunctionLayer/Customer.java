package FunctionLayer;

import java.util.Objects;

public class Customer {
    
    private int id;
    private String name;
    private String email;
    private String address;
    private int zipcode;
    private int phoneNumber;

    public Customer(String name, String email, String address, int zipcode, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", zipcode=" + zipcode + ", phoneNumber=" + phoneNumber + '}';
    }

}
