package dto;

public class Vehicle {
    //Attributes
    private String license_plate;
    private String brand;
    private int luggage_capacity;
    private int with_luggage_capacity;
	private int total_capacity;
	private String year_built;

	//Getters and Setters
    //license_plate
    public String getLicense_plate() { return license_plate; }
    public void setLicense_plate(String license_plate) { this.license_plate = license_plate; }
    //brand
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    //luggage_capacity
    public int getLuggage_capacity() { return luggage_capacity; }
    public void setLuggage_capacity(int luggage_capacity) { this.luggage_capacity = luggage_capacity; }
    //with_luggage_capacity
    public int getWith_luggage_capacity() { return with_luggage_capacity; }
    public void setWith_luggage_capacity(int with_luggage_capacity) { this.with_luggage_capacity = with_luggage_capacity; }
    //total_capacity
    public int getTotal_capacity() { return total_capacity; }
    public void setTotal_capacity(int total_capacity) { this.total_capacity = total_capacity; }
    //year_built
    public String getYear_built() { return year_built; }
    public void setYear_built(String year_built) { this.year_built = year_built; }

    //Constructor
    public Vehicle(String license_plate, String brand, int luggage_capacity, int with_luggage_capacity,
                   int total_capacity, String year_built) {
        this.setLicense_plate(license_plate);
        this.setBrand(brand);
        this.setLuggage_capacity(luggage_capacity);
        this.setWith_luggage_capacity(with_luggage_capacity);
        this.setTotal_capacity(total_capacity);
        this.setYear_built(year_built);
    }

    //Methods
}
