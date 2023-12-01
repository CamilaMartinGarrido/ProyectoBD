package dto;

public class Role {
    //Attributes
    private int id_role;
    private String name_role;

    //Getters and Setters
    //id_role
    public int getId_role() {
        return id_role;
    }
    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
    //name_role
    public String getName_role() {
        return name_role;
    }
    public void setName_role(String name_role) {
        this.name_role = name_role;
    }

    //Constructor
    public Role(int id_role, String name_role) {
        this.setId_role(id_role);
        this.setName_role(name_role);
    }
}