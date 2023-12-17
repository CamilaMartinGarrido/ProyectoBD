package dto;
import java.sql.Timestamp;
import java.util.Date;

public class Contract_Service extends Contract {
    //Attributes
    private int id_activity;

    //Getters and Setters
    public int getId_activity() {
        return id_activity;
    }
    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }

    //Constructor
    public Contract_Service(int id_contract, Timestamp start_contract, Timestamp end_contract, Timestamp resolution_contract,
                            String description_contract, String contract_type, int id_activity) {
        super(id_contract, start_contract, end_contract, resolution_contract, description_contract, contract_type);
        this.setId_activity(id_activity);
    }
}