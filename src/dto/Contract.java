package dto;
import services.ServicesLocator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;

public class Contract {

    //Attributes
    protected int id_contract;
    protected Timestamp start_contract;
    protected Timestamp end_contract;
    protected Timestamp resolution_contract;
    protected String description_contract;
    protected String contract_type;

	//Getters and Setters
    //id_contract
    public int getId_contract() { return id_contract; }
    public void setId_contract(int id_contract) {
        this.id_contract = id_contract;
    }
    //start_contract
    public Timestamp getStart_contract() {
        return start_contract;
    }
    public void setStart_contract(Timestamp start_contract) {
        this.start_contract = start_contract;
    }
    //end_contract
    public Timestamp getEnd_contract() {
        return end_contract;
    }
    public void setEnd_contract(Timestamp end_contract) {
        this.end_contract = end_contract;
    }
    //resolution_contract
    public Timestamp getResolution_contract() {
        return resolution_contract;
    }
    public void setResolution_contract(Timestamp resolution_contract) {
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
    public Contract(int id_contract, Timestamp start_contract, Timestamp end_contract, Timestamp resolution_contract,
                    String description_contract, String contract_type) {
        this.setId_contract(id_contract);
        this.setStart_contract(start_contract);
        this.setEnd_contract(end_contract);
        this.setResolution_contract(resolution_contract);
        this.setDescription_contract(description_contract);
        this.setContract_type(contract_type);
    }
    public Contract( Timestamp start_contract, Timestamp end_contract, Timestamp resolution_contract,
                    String description_contract, String contract_type) {

        this.setStart_contract(start_contract);
        this.setEnd_contract(end_contract);
        this.setResolution_contract(resolution_contract);
        this.setDescription_contract(description_contract);
        this.setContract_type(contract_type);
    }
}