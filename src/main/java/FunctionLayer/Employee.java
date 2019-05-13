/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Benjamin
 */
public class Employee {

    private String username;
    private String password;

    public Employee(String name, String password) {

        this.username = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" + "username=" + username + ", password=" + password + '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
}
