package dto;

import java.sql.Timestamp;

public class Contract {
    //Attributes
    private int id_contract;
    private Timestamp start_contract;
    private Timestamp end_contract;
    private Timestamp resolution_contract;
    private String description_contract;
    private int id_transportation;
    private int id_hotel_room_season;
    private int id_activity;

	//Getters and Setters
    //id_contract
    public int getId_contract() { return id_contract; }
    public void setId_contract(int id_contract) { this.id_contract = id_contract; }
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
    public void setResolution_contract(Timestamp resolution_contract) { this.resolution_contract = resolution_contract; }
    //description_contract
    public String getDescription_contract() {
        return description_contract;
    }
    public void setDescription_contract(String description_contract) { this.description_contract = description_contract; }
    //id_transportation
    public int getId_transportation() { return id_transportation; }
    public void setId_transportation(int id_transportation) { this.id_transportation = id_transportation; }
    //id_hotel_room_season
    public int getId_hotel_room_season() { return id_hotel_room_season; }
    public void setId_hotel_room_season(int id_hotel_room_season) { this.id_hotel_room_season = id_hotel_room_season; }
    //id_activity
    public int getId_activity() { return id_activity; }
    public void setId_activity(int id_activity) { this.id_activity = id_activity; }

    //Constructor with id
    public Contract(Timestamp start_contract, Timestamp end_contract, Timestamp resolution_contract,
                    String description_contract, int id_transportation, int id_hotel_room_season,
                    int id_activity) {
        this.setStart_contract(start_contract);
        this.setEnd_contract(end_contract);
        this.setResolution_contract(resolution_contract);
        this.setDescription_contract(description_contract);
        this.setId_transportation(id_transportation);
        this.setId_hotel_room_season(id_hotel_room_season);
        this.setId_activity(id_activity);
    }
    //Constructor with id
    public Contract(int id_contract, Timestamp start_contract, Timestamp end_contract, Timestamp resolution_contract,
                    String description_contract, int id_transportation, int id_hotel_room_season,
                    int id_activity) {
        this.setId_contract(id_contract);
        this.setStart_contract(start_contract);
        this.setEnd_contract(end_contract);
        this.setResolution_contract(resolution_contract);
        this.setDescription_contract(description_contract);
        this.setId_transportation(id_transportation);
        this.setId_hotel_room_season(id_hotel_room_season);
        this.setId_activity(id_activity);
    }
}