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

    public static Customer addCustomer(String name, String email, String address, int zipcode, int phoneNumber) throws FogException {
        Customer customer = null;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `FogCarport`.`customers` ( name, email, address, zipcode, phoneNumber ) "
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

    public static Employee addEmployee(Employee newEmployee) throws FogException {
        Employee employee = null;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `FogCarport`.`employees` ( name, password, isAdmin )"
                    + "VALUES (?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newEmployee.getUsername());
            ps.setString(2, newEmployee.getPassword());
            ps.setBoolean(3, newEmployee.isAdmin());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                employee = new Employee(rs.getInt(1), newEmployee.getUsername(), newEmployee.getPassword(), newEmployee.isAdmin());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
        return employee;
    }

    public static List<Customer> getAllCustomers() throws FogException {
        List<Customer> customers = new ArrayList();
        try {
            String SQL = "SELECT * FROM FogCarport.customers;";

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

    public static Employee getEmployee(int id) throws FogException {
        Employee employee = null;
        try {
            String SQL = "SELECT * FROM `FogCarport`.`employees` "
                    + "WHERE id = ? ";

            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                employee = new Employee(rs.getInt("id"), rs.getNString("name"), rs.getNString("password"), rs.getBoolean("isAdmin"));
            }
        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
        }
        return employee;
    }

    public static void deleteEmployee(int id) throws FogException {
        try {
            String SQL = "DELETE FROM `FogCarport`.`employees` WHERE (`id` = ?);";

            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public static List<Employee> getAllEmployees() throws FogException {
        List<Employee> employees = new ArrayList();
        try {
            String SQL = "SELECT * FROM FogCarport.employees;";

            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getNString("name"), rs.getNString("password"), rs.getBoolean("isAdmin")));
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    public static Employee setEmployee(int id, String username, String password, boolean isAdmin) throws FogException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `FogCarport`.`employees` SET `name` = ?, `password` = ?, `isAdmin` = ? WHERE (`id` = ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setBoolean(3, isAdmin);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
        return new Employee(id, password, password, isAdmin);
    }
}
