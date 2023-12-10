package dto;
import java.util.Date;

public class Contract {
    //Attributes
    protected int id_contract;
    protected Date start_contract;
    protected Date end_contract;
    protected Date resolution_contract;
    protected String description_contract;
    protected String contract_type;

	//Getters and Setters
    //id_contract
    public int getId_contract() { return id_contract; }
    public void setId_contract(int id_contract) {
        this.id_contract = id_contract;
    }
    //start_contract
    public Date getStart_contract() {
        return start_contract;
    }
    public void setStart_contract(Date start_contract) {
        this.start_contract = start_contract;
    }
    //end_contract
    public Date getEnd_contract() {
        return end_contract;
    }
    public void setEnd_contract(Date end_contract) {
        this.end_contract = end_contract;
    }
    //resolution_contract
    public Date getResolution_contract() {
        return resolution_contract;
    }
    public void setResolution_contract(Date resolution_contract) {
        this.resolution_contract = resolution_contract;
    }
    //description_contract
    public String getDescription_contract() {
        return description_contract;
    }
    public void setDescription_contract(String description_contract) { this.description_contract = description_contract; }
    //contract_type
    public String getContract_type() {
        return contract_type;
    }
    public void setContract_type(String contract_type) { this.contract_type = contract_type; }

    //Constructor
    public Contract(int id_contract, Date start_contract, Date end_contract, Date resolution_contract,
                    String description_contract, String contract_type) {
        this.setId_contract(id_contract);
        this.setStart_contract(start_contract);
        this.setEnd_contract(end_contract);
        this.setResolution_contract(resolution_contract);
        this.setDescription_contract(description_contract);
        this.setContract_type(contract_type);
    }
}