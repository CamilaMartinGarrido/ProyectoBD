package dto;

public class Business_Model {
    //Attributes
    private String idBM;
    private String nameBM;
	private Hotel hotel;

	//Getters and Setters
    //idBM
    public String getIdBM() { return idBM; }
    public void setIdBM(String idBM) { this.idBM = idBM; }
    //nameBM
    public String getNameBM() { return nameBM; }
    public void setNameBM(String nameBM) { this.nameBM = nameBM; }
    //hotel
    public Hotel getHotel() { return hotel; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    //Constructor
    public Business_Model(String idBM, String nameBM, Hotel hotel) {
        this.setIdBM(idBM);
        this.setNameBM(nameBM);
        this.setHotel(hotel);
    }

    //Methods
}