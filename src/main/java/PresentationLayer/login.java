/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import FunctionLayer.Employee;
import FunctionLayer.FogException;
import DataLayer.Connector;

/**
 *
 * @author benjaminbajrami
 */
public class login {
    public static Employee login(String username, String password) throws FogException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT username, password FROM user "
                    + "WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee emp = new Employee(username, password);
                return emp;
            } else {
                throw new FogException("Could not validate user");
            }
        } catch (SQLException ex) {
            throw new FogException(ex.getMessage());
        }
    }
}
