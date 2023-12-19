package dto;

public class Hotel_Room_Season{
    //Attributes
    private int id_hotel_room_season;
    private int id_hotel;
    private int id_room;
    private int id_season;

    //Getters and Setters
    //id_hotel_room_season
    public int getId_hotel_room_season() { return id_hotel_room_season; }
    public void setId_hotel_room_season(int id_hotel_room_season) { this.id_hotel_room_season = id_hotel_room_season; }
    //id_hotel
    public int getId_hotel() { return id_hotel; }
    public void setId_hotel(int id_hotel) { this.id_hotel = id_hotel; }
    //id_room
    public int getId_room() { return id_room; }
    public void setId_room(int id_room) { this.id_room = id_room; }
    //id_season
    public int getId_season() { return id_season; }
    public void setId_season(int id_season) { this.id_season = id_season; }

    //Constructor
    public Hotel_Room_Season(int id_hotel, int id_room, int id_season) {
        this.setId_hotel(id_hotel);
        this.setId_room(id_room);
        this.setId_season(id_season);
    }
}