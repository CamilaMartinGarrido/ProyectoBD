package dto;
import java.util.ArrayList;
import java.util.Date;

public class Hotel {
    //Attributes
    private int id_hotel;
    private String name_hotel;
    private String chain_hotel;
    private String category_hotel;
    private String address_hotel;
    private String province_hotel;
    private boolean is_active;
    private Date date_hotel;
    private String phone;
    private String fax;
    private String email;
    private double distance_to_city;
    private double distance_to_airport;
    private int room_count;
    private int floor_count;
    private String location_hotel;
    private int id_b_model;

	//Getters ans Setters
    //id_hotel
    public int getId_hotel() {
        return id_hotel;
    }
    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }
    //name_hotel
    public String getName_hotel() {
        return name_hotel;
    }
    public void setName_hotel(String name_hotel) {
        this.name_hotel = name_hotel;
    }
    //chain_hotel
    public String getChain_hotel() {
        return chain_hotel;
    }
    public void setChain_hotel(String chain_hotel) {
        this.chain_hotel = chain_hotel;
    }
    //category_hotel
    public String getCategory_hotel() {
        return category_hotel;
    }
    public void setCategory_hotel(String category_hotel) {
        this.category_hotel = category_hotel;
    }
    //address_hotel
    public String getAddress_hotel() {
        return address_hotel;
    }
    public void setAddress_hotel(String address_hotel) {
        this.address_hotel = address_hotel;
    }
    //province_hotel
    public String getProvince_hotel() {
        return province_hotel;
    }
    public void setProvince_hotel(String province_hotel) {
        this.province_hotel = province_hotel;
    }
    //is_active
    public boolean isIs_active() {
        return is_active;
    }
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
    //date_hotel
    public Date getDate_hotel() {
        return date_hotel;
    }
    public void setDate_hotel(Date date_hotel) {
        this.date_hotel = date_hotel;
    }
    //phone
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //fax
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    //email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //distance_to_city
    public double getDistance_to_city() {
        return distance_to_city;
    }
    public void setDistance_to_city(double distance_to_city) {
        this.distance_to_city = distance_to_city;
    }
    //distance_to_airport
    public double getDistance_to_airport() {
        return distance_to_airport;
    }
    public void setDistance_to_airport(double distance_to_airport) {
        this.distance_to_airport = distance_to_airport;
    }
    //room_count
    public int getRoom_count() {
        return room_count;
    }
    public void setRoom_count(int room_count) {
        this.room_count = room_count;
    }
    //floor_count
    public int getFloor_count() {
        return floor_count;
    }
    public void setFloor_count(int floor_count) {
        this.floor_count = floor_count;
    }
    //location_hotel
    public String getLocation_hotel() {
        return location_hotel;
    }
    public void setLocation_hotel(String location_hotel) {
        this.location_hotel = location_hotel;
    }
    //id_b_model
    public int getId_b_model() {
        return id_b_model;
    }
    public void setId_b_model(int id_b_model) {
        this.id_b_model = id_b_model;
    }

    //Constructor
    public Hotel(int id_hotel, String name_hotel, String chain_hotel, String category_hotel, String address_hotel,
                 String province_hotel, boolean is_active, Date date_hotel, String phone, String fax, String email,
                 double distance_to_city, double distance_to_airport, int room_count, int floor_count,
                 String location_hotel, int id_b_model) {
        this.setId_hotel(id_hotel);
        this.setName_hotel(name_hotel);
        this.setChain_hotel(chain_hotel);
        this.setCategory_hotel(category_hotel);
        this.setAddress_hotel(address_hotel);
        this.setProvince_hotel(province_hotel);
        this.setIs_active(is_active);
        this.setDate_hotel(date_hotel);
        this.setPhone(phone);
        this.setFax(fax);
        this.setEmail(email);
        this.setDistance_to_city(distance_to_city);
        this.setDistance_to_airport(distance_to_airport);
        this.setRoom_count(room_count);
        this.setFloor_count(floor_count);
        this.setLocation_hotel(location_hotel);
        this.setId_b_model(id_b_model);
    }
}