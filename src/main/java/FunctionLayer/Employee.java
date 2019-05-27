package FunctionLayer;

public class Employee {
    
    private int id;
    private String username;
    private String password;
    private boolean isAdmin = false; //no admin right as default

    /**
     * Creates a new employee which doesn't have admin rights as default
     * @param id
     * @param name
     * @param password
     * @param isAdmin 
     */
    public Employee(int id, String name, String password, boolean isAdmin) {
        this.id = id;
        this.username = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    public Employee(String name, String password, boolean isAdmin) {
        this.username = name;
        this.password = password;
        this.isAdmin = isAdmin;
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
    
    public boolean isAdmin() {
        return isAdmin;
    }
    
    public void setIsAdmin(boolean admin) {
        this.isAdmin = admin;
    }
    
}
