package dto;

public class User {
    //Attributes
    private String user_name;
    private int id_role;
    private String password;

    //Getters and Setters
    //user_name
    public String getUser_name() {
        return user_name;
    }
    public void setUsername(String user_name) {
        this.user_name = user_name;
    }
    //id_role
    public int getId_role() {
        return id_role;
    }
    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
    //password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //Constructor
    public User(String user_name, int id_role, String password) {
        this.setUsername(user_name);
        this.setId_role(id_role);
        this.setPassword(password);
    }
    public User(String user_name, int id_role){
        this.setUsername(user_name);
        this.setId_role(id_role);
    }
}