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

/**
 *
 * @author mikkel
 */
public class TestUserMapper {

    private static final Logger logger = Logger.getLogger(TestUserMapper.class.getName());

    /**
     *
     * @param name
     * @param email
     * @param address
     * @param zipcode
     * @param phoneNumber
     * @return
     * @throws FogException
     */
    public static Customer addCustomer(String name, String email, String address, int zipcode, int phoneNumber) throws FogException {
        Customer customer = null;
        try {
            Connection con = TestConnector.connection();
            String SQL = "INSERT INTO `FogCarportTestDB`.`customers` ( name, email, address, zipcode, phoneNumber ) "
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

    /**
     *
     * @param newEmployee
     * @return
     * @throws FogException
     */
    public static Employee addEmployee(Employee newEmployee) throws FogException {
        Employee employee = null;
        try {
            Connection con = TestConnector.connection();
            String SQL = "INSERT INTO `FogCarportTestDB`.`employees` ( name, password, isAdmin )"
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

    /**
     *
     * @return
     * @throws FogException
     */
    public static List<Customer> getAllCustomers() throws FogException {
        List<Customer> customers = new ArrayList();
        try {
            String SQL = "SELECT * FROM FogCarportTestDB.customers;";

            Connection con = TestConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getNString("name"), rs.getNString("email"), rs.getNString("address"), rs.getInt("zipcode"), rs.getInt("phoneNumber")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TestUserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    /**
     *
     * @param id
     * @return
     * @throws FogException
     */
    
    public static Employee getEmployee(int id) throws FogException {
        Employee employee = null;
        try {
            String SQL = "SELECT * FROM `FogCarportTestDB`.`employees` "
                    + "WHERE id = ? ";

            Connection con = TestConnector.connection();
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
    
    public static String getEmployeeName(int id) throws FogException {
        String employeeName = "";
        try {
            String SQL = "SELECT name FROM `FogCarportTestDB`.`employees` "
                    + "WHERE id = '" + id + "';";

            Connection con = TestConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employeeName = rs.getString("name");
            }
        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
        }
        return employeeName;
    }
    
    public static String getEmployeePassword(int id) throws FogException {

        String employeePassword = "";
        try {
            String SQL = "SELECT password FROM `FogCarportTestDB`.`employees` "
                    + "WHERE id = '" + id + "';";

            Connection con = TestConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                employeePassword = rs.getString("password");
                
            }
        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
        }
        return employeePassword;
    }
    /**
     *
     * @param id
     * @throws FogException
     */
    public static void deleteEmployee(int id) throws FogException {
        try {
            String SQL = "DELETE FROM `FogCarportTestDB`.`employees` WHERE (`id` = ?);";

            Connection con = TestConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     * @throws FogException
     */
    public static List<Employee> getAllEmployees() throws FogException {
        List<Employee> employees = new ArrayList();
        try {
            String SQL = "SELECT * FROM FogCarportTestDB.employees;";

            Connection con = TestConnector.connection();
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

    /**
     *
     * @param id
     * @param username
     * @param password
     * @param isAdmin
     * @return
     * @throws FogException
     */
    public static Employee setEmployee(int id, String username, String password) throws FogException {
        try {
            Connection con = TestConnector.connection();

            String SQL = "UPDATE `FogCarportTestDB`.`employees` SET `name` = ?, `password` = ? WHERE (`id` = ?);";

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
        return new Employee(id, username, password);
    }
}
