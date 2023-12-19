package dto;

public class Transportation  {
    //Attributes
    private int id_transportation;
    private int id_transp_model;
    private int id_vehicle;
    private String borrower;

    //Getters and Setters
    //id_transportation
    public int getId_transportation() { return id_transportation; }
    public void setId_transportation(int id_transportation) { this.id_transportation = id_transportation; }
    //id_transp_model
    public int getId_transp_model() {
        return id_transp_model;
    }
    public void setId_transp_model(int id_transp_model) {
        this.id_transp_model = id_transp_model;
    }
    //id_vehicle
    public int getId_vehicle() {
        return id_vehicle;
    }
    public void setId_vehicle(int id_vehicle) {
        this.id_vehicle = id_vehicle;
    }
    //borrower
    public String getBorrower() {
        return borrower;
    }
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    //Constructor without id
    public Transportation(int id_transp_model, int id_vehicle, String borrower) {
        this.setId_transp_model(id_transp_model);
        this.setId_vehicle(id_vehicle);
        this.setBorrower(borrower);
    }
    //Constructor with id
    public Transportation(int id_transportation, int id_transp_model, int id_vehicle, String borrower) {
        this.setId_transportation(id_transportation);
        this.setId_transp_model(id_transp_model);
        this.setId_vehicle(id_vehicle);
        this.setBorrower(borrower);
    }
}