package dto;

public class Transportation_Model {
    //Attributes
    protected int id_transp_model;
    protected String type_transp_model;
    protected String description_tm;

	//Getters and Setters
    //id_transp_model
    public int getId_transp_model() {
        return id_transp_model;
    }
    public void setId_transp_model(int id_transp_model) {
        this.id_transp_model = id_transp_model;
    }
    //type_transp_model
    public String getType_transp_model() {
        return type_transp_model;
    }
    public void setType_transp_model(String type_transp_model) {
        this.type_transp_model = type_transp_model;
    }
    //description_tm
    public String getDescription_tm() {
        return description_tm;
    }
    public void setDescription_tm(String description_tm) {
        this.description_tm = description_tm;
    }

    //Constructor
    public Transportation_Model(int id_transp_model, String type_transp_model, String description_tm) {
        this.setId_transp_model(id_transp_model);
        this.setType_transp_model(type_transp_model);
        this.setDescription_tm(description_tm);
    }
}