package dto;

public class Room {
    //Attributes
    private int id_room;
    private int room_number;
    private String room_type;
    private double room_cost;
    private double room_surcharge;
    private int id_plan;

    //Getters and Setters
    //id_room
    public int getId_room() {
        return id_room;
    }
    public void setId_room(int id_room) {
        this.id_room = id_room;
    }
    //room_number
    public int getRoom_number() {
        return room_number;
    }
    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }
    //room_type
    public String getRoom_type() {
        return room_type;
    }
    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }
    //room_cost
    public double getRoom_cost() {
        return room_cost;
    }
    public void setRoom_cost(double room_cost) {
        this.room_cost = room_cost;
    }
    //room_surcharge
    public double getRoom_surcharge() { return room_surcharge; }
    public void setRoom_surcharge(double room_surcharge) { this.room_surcharge = room_surcharge; }
    //id_plan
    public int getId_plan() { return id_plan; }
    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    //Constructor
    public Room(int id_room, int room_number, String room_type, double room_cost, double room_surcharge, int id_plan) {
        this.setId_room(id_room);
        this.setRoom_number(room_number);
        this.setRoom_type(room_type);
        this.setRoom_cost(room_cost);
        this.setRoom_surcharge(room_surcharge);
        this.setId_plan(id_plan);
    }
}