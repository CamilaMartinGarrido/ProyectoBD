package dto;

public class Business_Model {
    //Attributes
    private int id_b_model;
    private String name_b_model;

	//Getters and Setters
    //id_b_model
    public int getId_b_model() {
        return id_b_model;
    }
    public void setId_b_model(int id_b_model) {
        this.id_b_model = id_b_model;
    }
    //name_b_model
    public String getName_b_model() {
        return name_b_model;
    }
    public void setName_b_model(String name_b_model) {
        this.name_b_model = name_b_model;
    }

    //Constructor
    public Business_Model(int id_b_model, String name_b_model) {
        this.setId_b_model(id_b_model);
        this.setName_b_model(name_b_model);
    }
}