/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Customer;
import FunctionLayer.Employee;
import FunctionLayer.FogException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @authors Iben, Christian, Benjamin, Nicklas, Mikkel
 */
public class UserMapper {

    public static void addCustomer(Customer customer) throws FogException, SQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `FogCarport`.`customer` ( name, email, address, zipcode, phoneNumber ) "
                    + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getZipcode());
            ps.setString(5, customer.getPhoneNumber());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public static void getEmployee(Employee employee) throws FogException {
        try {
            Connection con = Connector.connection();

            String SQL = "SELECT * FROM FogCarport.`emplyee` "
                    + "WHERE `username`='" + employee.getUsername() + "';";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, employee.getPassword());
            ResultSet rs = ps.executeQuery(SQL);
            while (rs.next()) {
                /* Password */
                String username = rs.getString("username");
                employee = new Employee(username);
                employee.setUsername(username);
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public Employee getEmployee(String username) throws FogException, SQLException {
        Employee employee = new Employee();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM FogCarport.`emplyee` "
                    + "WHERE `username`='" + username + "';";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                /* Password */
                String pass = rs.getString("password");
                employee.setPassword(pass);
            }
            employee.setUsername(username);
        } catch (SQLException ex) {
            System.out.println(ex.getSQLState());
            System.out.println(ex.getLocalizedMessage());
        }
        return employee;
    }
}
