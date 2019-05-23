package FunctionLayer;

public class Employee {
    
    private int id;
    private String username;
    private String password;

    public Employee(int id, String name, String password) {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
