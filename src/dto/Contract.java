package dto;
import java.util.Date;

public class Contract {
    //Attributes
    private String idC;
	private String contract_type;
	private Date startC;
	private Date endC;
	private Date resolutionC;
	private String descriptionC;

	//Getters and Setters
    //
    public String getIdC() { return idC; }
    public void setIdC(String idC) { this.idC = idC; }
    //
    public String getContract_type() { return contract_type; }
    public void setContract_type(String contract_type) { this.contract_type = contract_type; }
    //
    public Date getStartC() { return startC; }
    public void setStartC(Date startC) { this.startC = startC; }
    //
    public Date getEndC() { return endC; }
    public void setEndC(Date endC) { this.endC = endC; }
    //
    public Date getResolutionC() { return resolutionC; }
    public void setResolutionC(Date resolutionC) { this.resolutionC = resolutionC;
    }
    //
    public String getDescriptionC() { return descriptionC; }
    public void setDescriptionC(String descriptionC) { this.descriptionC = descriptionC;
    }

    //Constructor
    public Contract(String idC, String contract_type, Date startC, Date endC, Date resolutionC, String descriptionC) {
        this.setIdC(idC);
        this.setContract_type(contract_type);
        this.setStartC(startC);
        this.setEndC(endC);
        this.setResolutionC(resolutionC);
        this.setDescriptionC(descriptionC);
    }

    //Methods
}