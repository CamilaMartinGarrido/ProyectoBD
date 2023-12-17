package dto;

import java.sql.Timestamp;

public class Contract_Hotel extends Contract {
    //Attributes
    private int id_hotel;
    private int id_room;
    private int id_season;

    //Getters and Setters
    //id_hotel
    public int getId_hotel() {
        return id_hotel;
    }
    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }
    //id_room
    public int getId_room() {
        return id_room;
    }
    public void setId_room(int id_room) {
        this.id_room = id_room;
    }
    //id_season
    public int getId_season() {
        return id_season;
    }
    public void setId_season(int id_season) {
        this.id_season = id_season;
    }

    //Constructor
    public Contract_Hotel(int id_contract, Timestamp start_contract, Timestamp end_contract, Timestamp resolution_contract,
                          String description_contract, String contract_type, int id_hotel, int id_room, int id_season) {
        super(id_contract, start_contract, end_contract, resolution_contract, description_contract, contract_type);
        this.setId_hotel(id_hotel);
        this.setId_room(id_room);
        this.setId_season(id_season);
    }
}