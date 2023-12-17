package dto;

public class Rol {
    //Attributes
    private int id_role;
    private String name_role;
    private String description_role;

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
    //description_role
    public String getDescription_role() { return description_role; }
    public void setDescription_role(String description_role) { this.description_role = description_role; }

    //Constructor
    public Rol(int id_role, String name_role, String description_role) {
        this.setId_role(id_role);
        this.setName_role(name_role);
        this.setDescription_role(description_role);
    }
}