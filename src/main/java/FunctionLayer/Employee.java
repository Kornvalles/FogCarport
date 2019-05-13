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
    private int employeeID;
    private String name;
    private String password;

    public Employee(int employeeID, String name, String password) {
        this.employeeID = employeeID;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", name=" + name + ", password=" + password + '}';
    }

    
    
    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    
}
