package dto;

public class Vehicle {
    //Attributes
    private int id_vehicle;
    private String license_plate;
    private String brand;
    private double luggage_capacity;
    private double with_luggage_capacity;
    private double total_capacity;
    private int year_build;

	//Getters and Setters
    //id_vehicle
    public int getId_vehicle() {
        return id_vehicle;
    }
    public void setId_vehicle(int id_vehicle) {
        this.id_vehicle = id_vehicle;
    }
    //license_plate
    public String getLicense_plate() {
        return license_plate;
    }
    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }
    //brand
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    //luggage_capacity
    public double getLuggage_capacity() {
        return luggage_capacity;
    }
    public void setLuggage_capacity(double luggage_capacity) {
        this.luggage_capacity = luggage_capacity;
    }
    //with_luggage_capacity
    public double getWith_luggage_capacity() {
        return with_luggage_capacity;
    }
    public void setWith_luggage_capacity(double with_luggage_capacity) {
        this.with_luggage_capacity = with_luggage_capacity;
    }
    //total_capacity
    public double getTotal_capacity() {
        return total_capacity;
    }
    public void setTotal_capacity(double total_capacity) {
        this.total_capacity = total_capacity;
    }
    //year_built
    public int getYear_build() {
        return year_build;
    }
    public void setYear_build(int year_build) {
        this.year_build = year_build;
    }

    //Constructor
    public Vehicle(int id_vehicle, String license_plate, String brand, double luggage_capacity,
                   double with_luggage_capacity, double total_capacity, int year_build) {
        this.setId_vehicle(id_vehicle);
        this.setLicense_plate(license_plate);
        this.setBrand(brand);
        this.setLuggage_capacity(luggage_capacity);
        this.setWith_luggage_capacity(with_luggage_capacity);
        this.setTotal_capacity(total_capacity);
        this.setYear_build(year_build);
    }
    public Vehicle( String license_plate, String brand, double luggage_capacity,
                   double with_luggage_capacity, double total_capacity, int year_build) {

        this.setLicense_plate(license_plate);
        this.setBrand(brand);
        this.setLuggage_capacity(luggage_capacity);
        this.setWith_luggage_capacity(with_luggage_capacity);
        this.setTotal_capacity(total_capacity);
        this.setYear_build(year_build);
    }
}