package dto;
import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    //Attributes
    private String idH;
    private String nameH;
    private String chainH;
    private String categoryH;
    private String provinceH;
    private String addressH;
    private boolean isActive;
    private Date date;
    private String phone;
    private String fax;
    private String email;
	private double distance_to_city;
	private double distance_to_airport;
	private int room_count;
	private int floor_count;
	private String locationH;
	private ArrayList<Room> rooms;

	//Getters ans Setters
    //idH
    public String getIdH() { return idH; }
    public void setIdH(String idH) { this.idH = idH; }
    //nameH
    public String getNameH() { return nameH; }
    public void setNameH(String nameH) { this.nameH = nameH; }
    //chainH
    public String getChainH() { return chainH; }
    public void setChainH(String chainH) { this.chainH = chainH; }
    //categoryH
    public String getCategoryH() { return categoryH; }
    public void setCategoryH(String categoryH) { this.categoryH = categoryH; }
    //provinceH
    public String getProvinceH() { return provinceH; }
    public void setProvinceH(String provinceH) { this.provinceH = provinceH; }
    //addressH
    public String getAddressH() { return addressH; }
    public void setAddressH(String addressH) { this.addressH = addressH; }
    //isActive
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    //date
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    //phone
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    //fax
    public String getFax() { return fax; }
    public void setFax(String fax) { this.fax = fax; }
    //email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    //distance_to_city
    public double getDistance_to_city() { return distance_to_city; }
    public void setDistance_to_city(double distance_to_city) { this.distance_to_city = distance_to_city; }
    //distance_To_Airport
    public double getDistance_to_airport() { return distance_to_airport; }
    public void setDistance_to_airport(double distance_to_airport) { this.distance_to_airport = distance_to_airport; }
    //room_count
    public int getRoom_count() { return room_count; }
    public void setRoom_count(int room_count) { this.room_count = room_count; }
    //floor_count
    public int getFloor_count() { return floor_count; }
    public void setFloor_count(int floor_count) { this.floor_count = floor_count; }
    //locationH
    public String getLocationH() { return locationH; }
    public void setLocationH(String locationH) { this.locationH = locationH; }

    //Constructor
    public Hotel(String idH, String nameH, String chainH, String categoryH, String provinceH, String addressH,
                 boolean isActive, Date date, String phone, String fax, String email, double distance_to_city,
                 double distance_to_airport, int room_count, int floor_count, String locationH) {
        this.setIdH(idH);
        this.setNameH(nameH);
        this.setChainH(chainH);
        this.setCategoryH(categoryH);
        this.setProvinceH(provinceH);
        this.setAddressH(addressH);
        this.setActive(isActive);
        this.setDate(date);
        this.setPhone(phone);
        this.setFax(fax);
        this.setEmail(email);
        this.setDistance_to_city(distance_to_city);
        this.setDistance_to_airport(distance_to_airport);
        this.setRoom_count(room_count);
        this.setFloor_count(floor_count);
        this.setLocationH(locationH);
    }

    //Methods
}