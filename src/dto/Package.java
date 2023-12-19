package dto;

public class Package {
    //Attributes
    private int id_package;
    private String promotional_name;
    private int days_count;
    private int nights_count;
    private int pax_count;
    private double total_hotel_cost;
    private double hotel_airport_ride_cost;
    private double total_transportation_cost;
    private double total_package_cost;
    private double percent_profit;
    private int id_contract;

    //Getters and Setters
    //id_package
    public int getId_package() {
        return id_package;
    }
    public void setId_package(int id_package) { this.id_package = id_package; }
    //promotional_name
    public String getPromotional_name() {
        return promotional_name;
    }
    public void setPromotional_name(String promotional_name) {
        this.promotional_name = promotional_name;
    }
    //days_count
    public int getDays_count() {
        return days_count;
    }
    public void setDays_count(int days_count) {
        this.days_count = days_count;
    }
    //nights_count
    public int getNights_count() {
        return nights_count;
    }
    public void setNights_count(int nights_count) {
        this.nights_count = nights_count;
    }
    //pax_count
    public int getPax_count() {
        return pax_count;
    }
    public void setPax_count(int pax_count) {
        this.pax_count = pax_count;
    }
    //total_hotel_cost
    public double getTotal_hotel_cost() {
        return total_hotel_cost;
    }
    public void setTotal_hotel_cost(double total_hotel_cost) {
        this.total_hotel_cost = total_hotel_cost;
    }
    //hotel_airport_ride_cost
    public double getHotel_airport_ride_cost() {
        return hotel_airport_ride_cost;
    }
    public void setHotel_airport_ride_cost(double hotel_airport_ride_cost) { this.hotel_airport_ride_cost = hotel_airport_ride_cost; }
    //total_transportation_cost
    public double getTotal_transportation_cost() {
        return total_transportation_cost;
    }
    public void setTotal_transportation_cost(double total_transportation_cost) { this.total_transportation_cost = total_transportation_cost; }
    //total_package_cost
    public double getTotal_package_cost() {
        return total_package_cost;
    }
    public void setTotal_package_cost(double total_package_cost) {
        this.total_package_cost = total_package_cost;
    }
    //percent_profit
    public double getPercent_profit() { return percent_profit; }
    public void setPercent_profit(double percent_profit) { this.percent_profit = percent_profit; }
    //id_contract
    public int getId_contract() {
        return id_contract;
    }
    public void setId_contract(int id_contract) {
        this.id_contract = id_contract;
    }

    //Constructor without id
    public Package(String promotional_name, int days_count, int nights_count, int pax_count,
                   double hotel_airport_ride_cost, double percent_profit) {
        this.setPromotional_name(promotional_name);
        this.setDays_count(days_count);
        this.setNights_count(nights_count);
        this.setPax_count(pax_count);
        this.setHotel_airport_ride_cost(hotel_airport_ride_cost);
        this.setPercent_profit(percent_profit);
    }
    //Constructor with id
    public Package(int id_package, String promotional_name, int days_count, int nights_count, int pax_count,
                   double total_hotel_cost, double hotel_airport_ride_cost, double total_transportation_cost,
                   double total_package_cost, double percent_profit) {
        this.setId_package(id_package);
        this.setPromotional_name(promotional_name);
        this.setDays_count(days_count);
        this.setNights_count(nights_count);
        this.setPax_count(pax_count);
        this.setTotal_hotel_cost(total_hotel_cost);
        this.setHotel_airport_ride_cost(hotel_airport_ride_cost);
        this.setTotal_transportation_cost(total_transportation_cost);
        this.setTotal_package_cost(total_package_cost);
        this.setPercent_profit(percent_profit);
    }

    public Package(int id_package, String promotional_name, int days_count, int nights_count, int pax_count,
                   double hotel_airport_ride_cost, double percent_profit) {
        this.setId_package(id_package);
        this.setPromotional_name(promotional_name);
        this.setDays_count(days_count);
        this.setNights_count(nights_count);
        this.setPax_count(pax_count);
        this.setHotel_airport_ride_cost(hotel_airport_ride_cost);
        this.setPercent_profit(percent_profit);
    }
}