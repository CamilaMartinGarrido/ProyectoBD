package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class BusinessModelService {

    public void add_business_model(String name, int business_model_hotel) throws SQLException {
        String function = "{call add_business_model(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, name);
        preparedFunction.setInt(2, business_model_hotel);


        preparedFunction.close();
    }

    public void delete_business_model(int cod) throws SQLException {
        String function = "{call delete_business_model(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_business_model(int cod, String name) throws SQLException {
        String function = "{call update_business_model(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, name);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
