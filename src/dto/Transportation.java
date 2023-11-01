package dto;

import java.util.ArrayList;

public class Transportation {
    //Attributes
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Transportation_Model> models;
    private String borrower;

    //Getters and Setters
    //vehicles
    public ArrayList<Vehicle> getVehicles() { return vehicles; }
    //models
    public ArrayList<Transportation_Model> getModels() { return models; }
    //borrower
    public String getBorrower() { return borrower; }
    public void setBorrower(String borrower) { this.borrower = borrower; }

    //Constructor
    public Transportation(String borrower) {
        this.setBorrower(borrower);
    }
}
