package services;

import java.sql.CallableStatement;
import java.sql.SQLException;


public class Km_CostService {
    public void add_km_cost(double v_km_cost, double v_full_ride_cost, double v_waiting_hours_cost) throws SQLException {
        String function = "{call add_km_cost(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setDouble(1, v_km_cost);
        preparedFunction.setDouble(2, v_full_ride_cost);
        preparedFunction.setDouble(3, v_waiting_hours_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_km_cost(int cod) throws SQLException {
        String function = "{call delete_km_cost(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_km_cost(int cod, double v_km_cost, double v_full_ride_cost, double v_waiting_hours_cost) throws SQLException {
        String function = "{call update_km_cost(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setDouble(2, v_km_cost);
        preparedFunction.setDouble(3, v_full_ride_cost);
        preparedFunction.setDouble(4, v_waiting_hours_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
