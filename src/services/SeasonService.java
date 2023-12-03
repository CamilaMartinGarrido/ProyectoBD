package services;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

public class SeasonService {
    public void add_season(String name, Timestamp start, Timestamp end, String description_season) throws SQLException {
        String function = "{call add_season(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, name);
        preparedFunction.setTimestamp(2, start);
        preparedFunction.setTimestamp(3, end);
        preparedFunction.setString(4,description_season);


        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_season(int cod) throws SQLException {
        String function = "{call delete_season(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_season(int cod,String name, Timestamp start, Timestamp end, String description_season) throws SQLException {
        String function = "{call update_season(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, name);
        preparedFunction.setTimestamp(3, start);
        preparedFunction.setTimestamp(4, end);
        preparedFunction.setString(5,description_season);




        preparedFunction.execute();

        preparedFunction.close();
    }
}
