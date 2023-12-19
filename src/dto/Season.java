package dto;
import java.util.Date;

public class Season {
    //Attributes
    private int id_season;
    private String name_season;
    private Date start_season;
    private Date end_season;
    private String description_season;

    //Getters and Setters
    //id_season
    public int getId_season() {
        return id_season;
    }
    public void setId_season(int id_season) {
        this.id_season = id_season;
    }
    //name_season
    public String getName_season() {
        return name_season;
    }
    public void setName_season(String name_season) {
        this.name_season = name_season;
    }
    //start_season
    public Date getStart_season() {
        return start_season;
    }
    public void setStart_season(Date start_season) {
        this.start_season = start_season;
    }
    //end_season
    public Date getEnd_season() {
        return end_season;
    }
    public void setEnd_season(Date end_season) {
        this.end_season = end_season;
    }
    //description_season
    public String getDescription_season() {
        return description_season;
    }
    public void setDescription_season(String description_season) {
        this.description_season = description_season;
    }

    //Constructor without id
    public Season(String name_season, Date start_season, Date end_season, String description_season) {
        this.setName_season(name_season);
        this.setStart_season(start_season);
        this.setEnd_season(end_season);
        this.setDescription_season(description_season);
    }
    //Constructor with id
    public Season(int id_season, String name_season, Date start_season, Date end_season, String description_season) {
        this.setId_season(id_season);
        this.setName_season(name_season);
        this.setStart_season(start_season);
        this.setEnd_season(end_season);
        this.setDescription_season(description_season);
    }
}