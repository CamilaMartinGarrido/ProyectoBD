package dto;
import java.util.Date;

public class Contract_Transportation extends Contract {
    //Attributes
    private int id_transp_model;
    private int id_vehicle;
    private String borrower;

    //Getters and Setters
    //id_transp_model
    public int getId_transp_model() {
        return id_transp_model;
    }
    public void setId_transp_model(int id_transp_model) {
        this.id_transp_model = id_transp_model;
    }
    //id_vehicle
    public int getId_vehicle() {
        return id_vehicle;
    }
    public void setId_vehicle(int id_vehicle) {
        this.id_vehicle = id_vehicle;
    }
    //borrower
    public String getBorrower() {
        return borrower;
    }
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    //Constructor

    public Contract_Transportation(int id_contract, Date start_contract, Date end_contract, Date resolution_contract,
                                   String description_contract, String contract_type, int id_transp_model,
                                   int id_vehicle, String borrower) {
        super(id_contract, start_contract, end_contract, resolution_contract, description_contract, contract_type);
        this.setId_transp_model(id_transp_model);
        this.setId_vehicle(id_vehicle);
        this.setBorrower(borrower);
    }
}