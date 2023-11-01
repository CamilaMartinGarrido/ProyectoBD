package dto;

public class Transportation_Model {
    //Attributes
    protected String idTM;
    protected String typeTM;
	protected String descriptionTM;

	//Getters and Setters
    //idTM
    public String getIdTM() { return idTM; }
    public void setIdTM(String idTM) { this.idTM = idTM; }
    //typeTM
    public String getTypeTM() { return typeTM; }
    public void setTypeTM(String typeTM) { this.typeTM = typeTM; }
    //descriptionTM
    public String getDescriptionTM() { return descriptionTM; }
    public void setDescriptionTM(String descriptionTM) { this.descriptionTM = descriptionTM; }

    //Constructor
    public Transportation_Model(String idTM, String typeTM, String descriptionTM) {
        this.setIdTM(idTM);
        this.setTypeTM(typeTM);
        this.setDescriptionTM(descriptionTM);
    }

    //Methods
}