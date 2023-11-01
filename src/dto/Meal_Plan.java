package dto;

import java.util.ArrayList;

public class Meal_Plan {
    //Attributes
    private String id_plan;
    private String plan_type;
    private double plan_cost;
    private ArrayList<Room> rooms;

    //Getters and Setters
    //id_plan
    public String getId_plan() { return id_plan; }
    public void setId_plan(String id_plan) { this.id_plan = id_plan; }
    //plan_type
    public String getPlan_type() { return plan_type; }
    public void setPlan_type(String plan_type) { this.plan_type = plan_type; }
    //plan_cost
    public double getPlan_cost() { return plan_cost; }
    public void setPlan_cost(double plan_cost) { this.plan_cost = plan_cost; }

    //Constructor
    public Meal_Plan(String id_plan, String plan_type, double plan_cost) {
        this.setId_plan(id_plan);
        this.setPlan_type(plan_type);
        this.setPlan_cost(plan_cost);
    }

    //Methods
}