package dto;
import java.util.ArrayList;

public class Hotel_Season {
    //Attributes
    private ArrayList<Hotel> hotels;
    private ArrayList<Season> seasons;

    //Getters and Setters
    //hotels
    public ArrayList<Hotel> getHotels() { return hotels; }
    //seasons
    public ArrayList<Season> getSeasons() { return seasons; }

    //Constructor
    public Hotel_Season(ArrayList<Hotel> hotels, ArrayList<Season> seasons) {
        this.hotels = hotels;
        this.seasons = seasons;
    }
}
