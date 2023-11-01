package dto;

public class Room {
    //Attributes
    private int room_number;
	private String room_type;
	private double room_cost;

    //Getters and Setters
    //room_number
    public int getRoom_number() { return room_number; }
    public void setRoom_number(int room_number) { this.room_number = room_number; }
    //room_type
    public String getRoom_type() { return room_type; }
    public void setRoom_type(String room_type) { this.room_type = room_type; }
    //room_cost
    public double getRoom_cost() { return room_cost; }
    public void setRoom_cost(double room_cost) { this.room_cost = room_cost; }

    //Constructor
    public Room(int room_number, String room_type, double room_cost) {
        this.setRoom_number(room_number);
        this.setRoom_type(room_type);
        this.setRoom_cost(room_cost);
    }

    //Methods
}