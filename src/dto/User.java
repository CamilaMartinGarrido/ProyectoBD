package dto;

public class User {


    //Attributes
    private int id_user;
    private String user_name;
    private String password;
    private int id_role;
private  String name_role;
    //Getters and Setters
    //id_user
    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }
    //user_name
    public String getUser_name() {
        return user_name;
    }
    public void setUsername(String user_name) {
        this.user_name = user_name;
    }
    //password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    //id_role
    public int getId_role() {
        return id_role;
    }
    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
    public String getDescription_role() {
        return name_role;
    }

    public void setname_role(String description_role) {
        this.name_role = description_role;
    }

    //Constructor
    public User(int id_user, String user_name, String password, int id_role) {
        this.setId_user(id_user);
        this.setUsername(user_name);
        this.setPassword(password);
        this.setId_role(id_role);
    }
    public User(String user_name,int id_role){
        this.setUsername(user_name);
        this.setId_role(id_role);

    }
    public User( String user_name, String password, int id_role) {
        this.setId_user(id_user);
        this.setUsername(user_name);
        this.setPassword(password);
        this.setId_role(id_role);

    }
}