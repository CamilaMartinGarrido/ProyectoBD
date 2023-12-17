package dto;

public class Km_Cost extends Transportation_Model {
    //Attributes
    private double km_cost;
    private double full_ride_km_cost;
	private double waiting_hours_cost;

    //Getters and Setters
    //km_cost
    public double getKm_cost() {
        return km_cost;
    }
    public void setKm_cost(double km_cost) {
        this.km_cost = km_cost;
    }
    //full_ride_km_cost
    public double getFull_ride_km_cost() {
        return full_ride_km_cost;
    }
    public void setFull_ride_km_cost(double full_ride_km_cost) {
        this.full_ride_km_cost = full_ride_km_cost;
    }
    //waiting_hours_cost
    public double getWaiting_hours_cost() {
        return waiting_hours_cost;
    }
    public void setWaiting_hours_cost(double waiting_hours_cost) {
        this.waiting_hours_cost = waiting_hours_cost;
    }

    //Constructor
    public Km_Cost(int id_transp_model, String type_transp_model, String description_tm, double km_cost,
                   double full_ride_km_cost, double waiting_hours_cost) {
        super(id_transp_model, type_transp_model, description_tm);
        this.setKm_cost(km_cost);
        this.setFull_ride_km_cost(full_ride_km_cost);
        this.setWaiting_hours_cost(waiting_hours_cost);
    }
}