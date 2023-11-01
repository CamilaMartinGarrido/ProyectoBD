package dto;

import java.util.Date;

public class Season {
    //Attributes
    private String idS;
    private String nameS;
    private Date startS;
    private Date endS;
    private String descriptionS;

    //Getters and Setters
    //idS
    public String getIdS() { return idS; }
    public void setIdS(String idS) { this.idS = idS; }
    //nameS
    public String getNameS() { return nameS; }
    public void setNameS(String nameS) { this.nameS = nameS; }
    //starS
    public Date getStartS() { return startS; }
    public void setStartS(Date startS) { this.startS = startS; }
    //endS
    public Date getEndS() { return endS; }
    public void setEndS(Date endS) { this.endS = endS; }
    //descriptionS
    public String getDescriptionS() { return descriptionS; }
    public void setDescriptionS(String descriptionS) { this.descriptionS = descriptionS; }

    //Constructor
    public Season(String idS, String nameS, Date startS, Date endS, String descriptionS) {
        this.setIdS(idS);
        this.setNameS(nameS);
        this.setStartS(startS);
        this.setEndS(endS);
        this.setDescriptionS(descriptionS);
    }

    //Methods
}