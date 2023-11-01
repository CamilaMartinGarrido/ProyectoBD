package dto;

public class Km_H_Cost extends Transportation_Model{
    //Attributes
    private double route_km_cost;
	private double hours_cost;
	private double extra_km_cost;
	private double extras_hours_cost;

    //Getters and Setters
    //route_km_cost
    public double getRoute_km_cost() { return route_km_cost; }
    public void setRoute_km_cost(double route_km_cost) { this.route_km_cost = route_km_cost; }
    //hours_cost
    public double getHours_cost() { return hours_cost; }
    public void setHours_cost(double hours_cost) { this.hours_cost = hours_cost; }
    //extra_km_cost
    public double getExtra_km_cost() { return extra_km_cost; }
    public void setExtra_km_cost(double extra_km_cost) { this.extra_km_cost = extra_km_cost; }
    //extras_hours_cost
    public double getExtras_hours_cost() { return extras_hours_cost; }
    public void setExtras_hours_cost(double extras_hours_cost) { this.extras_hours_cost = extras_hours_cost; }

    //Constructor
    public Km_H_Cost(String idTM, String typeTM, String descriptionTM, double route_km_cost, double hours_cost,
            double extra_km_cost, double extras_hours_cost) {
        super(idTM, typeTM, descriptionTM);
        this.setRoute_km_cost(route_km_cost);
        this.setHours_cost(hours_cost);
        this.setExtra_km_cost(extra_km_cost);
        this.setExtras_hours_cost(extras_hours_cost);
    }

    //Methods
}