package dto;

public class Route extends Transportation_Model{
    //Attributes
    private String description_route;
    private double route_cost;
	private double full_ride_cost;

    //Getters and Setters
    //description_route
    public String getDescription_route() { return description_route; }
    public void setDescription_route(String description_route) { this.description_route = description_route; }
    //route_cost
    public double getRoute_cost() { return route_cost; }
    public void setRoute_cost(double route_cost) { this.route_cost = route_cost; }
    //full_ride_cost
    public double getFull_ride_cost() { return full_ride_cost; }
    public void setFull_ride_cost(double full_ride_cost) { this.full_ride_cost = full_ride_cost; }

    //Constructor
    public Route(String idTM, String typeTM, String descriptionTM, String description_route,
            double route_cost, double full_ride_cost) {
        super(idTM, typeTM, descriptionTM);
        this.setDescription_route(description_route);
        this.setRoute_cost(route_cost);
        this.setFull_ride_cost(full_ride_cost);
    }

    //Methods
}