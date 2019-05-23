package DataLayer;

import FunctionLayer.Customer;
import FunctionLayer.Employee;
import FunctionLayer.FogException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper {

    private static final Logger logger = Logger.getLogger(UserMapper.class.getName());

    public static Customer addCustomer(String name, String email, String address, int zipcode, int phoneNumber) throws FogException{
        Customer customer = null;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `FogCarport`.`customer` ( name, email, address, zipcode, phoneNumber ) "
                    + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setInt(4, zipcode);
            ps.setInt(5, phoneNumber);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            customer = new Customer(1, name, email, address, zipcode, phoneNumber);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
        return customer;
    }
    
    public static List<Customer> getAllCustomers() throws FogException {
        List<Customer> customers = new ArrayList();
        try {
            String SQL = "SELECT * FROM FogCarport.customer;";
            
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("id"), rs.getNString("name"), rs.getNString("email"), rs.getNString("address"), rs.getInt("zipcode"), rs.getInt("phoneNumber"));
                customers.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
    
    public static Employee getEmployee(String username) throws FogException {
        Employee employee = null;
        try {
            String SQL = "SELECT * FROM `FogCarport`.`employee` "
                    + "WHERE name = ? ";
            
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                employee = new Employee(rs.getInt("id"), rs.getNString("name"), rs.getNString("password"));
            }
        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
        }
        return employee;
    }
}
