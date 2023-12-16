package services;

import dto.Contract;
import dto.Daily_Activity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

public class DailyActivityService {
    public static LinkedList<Daily_Activity> getActivities() throws SQLException {
        LinkedList<Daily_Activity> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT daily_activity.*" +
                        "FROM public.daily_activity"
        );
        while (res.next()) {
            list.add(new Daily_Activity(res.getTimestamp("date_activity"),
                    res.getTimestamp("time_activity"),
                    res.getDouble("cost_activity"),
                    res.getString("description_activity")
            ));
        }
        return list;
    }



    public void add_daily_activity(Daily_Activity d) throws SQLException {
        String function = "{call add_daily_activity(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setTimestamp(1, d.getDay_activity());
        preparedFunction.setTimestamp(1, d.getTime_activity());
        preparedFunction.setString(1, d.getDescription_activity());
        preparedFunction.setDouble(1, d.getCost_activity());

        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_daily_activity(Daily_Activity d) throws SQLException {
        String function = "{call delete_daily_activity(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, d.getId_activity());
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_daily_activity(Daily_Activity d) throws SQLException {
        String function = "{call update_daily_activity(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, d.getId_activity());
        preparedFunction.setTimestamp(1, d.getDay_activity());
        preparedFunction.setTimestamp(1, d.getTime_activity());
        preparedFunction.setString(1, d.getDescription_activity());
        preparedFunction.setDouble(1, d.getCost_activity());

        preparedFunction.execute();

        preparedFunction.close();
    }
}
