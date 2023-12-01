package dto;
import java.sql.Time;
import java.util.Date;

public class Daily_Activity {
    //Attributes
    private int id_activity;
    private Date date_activity;
    private Time time_activity;
    private double cost_activity;
    private String description_activity;

    //Getters and Setters
    //id_activity
    public int getId_activity() {
        return id_activity;
    }
    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }
    //date_activity
    public Date getDate_activity() {
        return date_activity;
    }
    public void setDate_activity(Date date_activity) {
        this.date_activity = date_activity;
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
    //description_activity
    public String getDescription_activity() {
        return description_activity;
    }
    public void setDescription_activity(String description_activity) {
        this.description_activity = description_activity;
    }

    //Constructor
    public Daily_Activity(int id_activity, Date date_activity, Time time_activity, double cost_activity,
                          String description_activity) {
        this.setId_activity(id_activity);
        this.setDate_activity(date_activity);
        this.setTime_activity(time_activity);
        this.setCost_activity(cost_activity);
        this.setDescription_activity(description_activity);
    }
}
