package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Transportation_Model_Service {
    public void add_transportation_model(String type, String description) throws SQLException {
        String function = "{call add_transportation_model(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, type);
        preparedFunction.setString(2, description);


        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_transportation_model(int cod) throws SQLException {
        String function = "{call delete_transportation_model(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_transportation_model(int cod, String type, String description) throws SQLException {
        String function = "{call update_transportation_model(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, type);
        preparedFunction.setString(3, description);


        preparedFunction.execute();

        preparedFunction.close();
    }
}
