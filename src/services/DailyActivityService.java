package services;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Date;

public class DailyActivityService {
    public void add_daily_activity(Date date_activity, Date time_activity, String description, double cost) throws SQLException {
        String function = "{call add_daily_activity(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setDate(1, (java.sql.Date) date_activity);
        preparedFunction.setDate(2, (java.sql.Date) time_activity);
        preparedFunction.setString(3, description);
        preparedFunction.setDouble(4, cost);

        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_daily_activity(int cod) throws SQLException {
        String function = "{call delete_daily_activity(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_daily_activity(int cod, Date date_activity, Date time_activity, String description, double cost) throws SQLException {
        String function = "{call update_daily_activity(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setDate(2, (java.sql.Date) date_activity);
        preparedFunction.setDate(3, (java.sql.Date) time_activity);
        preparedFunction.setString(4, description);
        preparedFunction.setDouble(5, cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
