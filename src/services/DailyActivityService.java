package services;
import dto.Daily_Activity;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;

public class DailyActivityService {
    //List of Activities
    public static LinkedList<Daily_Activity> getActivities() throws SQLException {
        LinkedList<Daily_Activity> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT daily_activity.*" +
                        "FROM public.daily_activity"
        );
        while (res.next()) {
            list.add(new Daily_Activity(
                    res.getInt("id_activity"),
                    res.getString("type_activity"),
                    res.getString("day_activity"),
                    res.getTimestamp("time_activity"),
                    res.getDouble("cost_activity"),
                    res.getString("province_activity"),
                    res.getString("description_activity"),
                    res.getBoolean("is_valid"),
                    res.getDouble("surcharge_activity")
            ));
        }
        return list;
    }
    //Add
    public void add_daily_activity(Daily_Activity d) throws SQLException {
        String function = "{call add_daily_activity(?,?,?,?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1,d.getType_activity());
        preparedFunction.setString(2, d.getDay_activity());
        preparedFunction.setTimestamp(3, d.getTime_activity());
        preparedFunction.setDouble(4, d.getCost_activity());
        preparedFunction.setString(5, d.getProvince_activity());
        preparedFunction.setString(6, d.getDescription_activity());
        preparedFunction.setNull(7, 7);
        preparedFunction.setDouble(8,d.getSurcharge_activity());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_daily_activity(Daily_Activity d) throws SQLException {
        String function = "{call public.delete_daily_activity(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, d.getId_activity());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Update
    public void update_daily_activity(Daily_Activity d) throws SQLException {
        String function = "{call update_daily_activity(?,?,?,?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, d.getId_activity());
        preparedFunction.setTimestamp(2, Timestamp.valueOf(d.getDay_activity()));
        preparedFunction.setTimestamp(3, d.getTime_activity());
        preparedFunction.setString(4, d.getDescription_activity());
        preparedFunction.setDouble(5, d.getCost_activity());
        preparedFunction.setString(6,d.getType_activity());
        preparedFunction.setString(7, d.getProvince_activity());
        preparedFunction.setDouble(8,d.getSurcharge_activity());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Find
    public boolean findActivity(Daily_Activity daily_activity) throws SQLException {
        LinkedList<Daily_Activity> list = getActivities();
        Iterator<Daily_Activity> iter = list.iterator();
        boolean aux = false;
        while(iter.hasNext() && !aux){
            Daily_Activity d = iter.next();
            if(d.getId_activity() == daily_activity.getId_activity()){
                aux = true;
            }
        }
        return aux;
    }
}
