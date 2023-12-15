package dto;
import java.sql.Time;
import java.util.Date;

public class Daily_Activity {
    //Attributes
    private int id_activity;
    private String type_activity;
    private String day_activity;
    private Time time_activity;
    private double cost_activity;
    private String province_activity;
    private String description_activity;
    private double surcharge_activity;
    private boolean is_valid;

    //Getters and Setters
    //id_activity
    public int getId_activity() {
        return id_activity;
    }
    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }
    //type_activity
    public String getType_activity() { return type_activity; }
    public void setType_activity(String type_activity) { this.type_activity = type_activity; }
    //date_activity
    public String getDay_activity() {
        return day_activity;
    }
    public void setDay_activity(String day_activity) {
        this.day_activity = day_activity;
    }
    //time_activity
    public Time getTime_activity() {
        return time_activity;
    }
    public void setTime_activity(Time time_activity) {
        this.time_activity = time_activity;
    }
    //cost_activity
    public double getCost_activity() {
        return cost_activity;
    }
    public void setCost_activity(double cost_activity) {
        this.cost_activity = cost_activity;
    }
    //province_activity
    public String getProvince_activity() { return province_activity; }
    public void setProvince_activity(String province_activity) { this.province_activity = province_activity; }
    //description_activity
    public String getDescription_activity() {
        return description_activity;
    }
    public void setDescription_activity(String description_activity) { this.description_activity = description_activity; }
    //surcharge_activity
    public double getSurcharge_activity() { return surcharge_activity; }
    public void setSurcharge_activity(double surcharge_activity) { this.surcharge_activity = surcharge_activity; }
    //is_valid
    public boolean isIs_valid() { return is_valid; }
    public void setIs_valid(boolean is_valid) { this.is_valid = is_valid; }

    //Constructor
    public Daily_Activity(int id_activity, String type_activity, String day_activity, Time time_activity, double cost_activity,
                          String province_activity, String description_activity, double surcharge_activity, boolean is_valid) {
        this.setId_activity(id_activity);
        this.setType_activity(type_activity);
        this.setDay_activity(day_activity);
        this.setTime_activity(time_activity);
        this.setCost_activity(cost_activity);
        this.setProvince_activity(province_activity);
        this.setDescription_activity(description_activity);
        this.setSurcharge_activity(surcharge_activity);
        this.setIs_valid(is_valid);
    }
}