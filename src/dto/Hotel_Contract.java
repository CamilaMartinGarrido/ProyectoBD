package dto;
import java.util.Date;

public class Hotel_Contract extends Contract{
    //Attributes
    private Hotel hotel;

    //Getters and Setters
    //hotel
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    //Constructor
    public Hotel_Contract(String idC, String contract_type, Date startC, Date endC, Date resolutionC,
                          String descriptionC, Hotel hotel) {
        super(idC, contract_type, startC, endC, resolutionC, descriptionC);
        this.setHotel(hotel);
    }

    //Methods
}