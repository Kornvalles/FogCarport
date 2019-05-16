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
    private String id;

    public Employee(String id, String name, String password) {

        this.id = id;
        this.username = name;
        this.password = password;
    }
    
    public Employee(String name, String password) {

        this.username = name;
        this.password = password;
    }
    
    public Employee(String password) {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
