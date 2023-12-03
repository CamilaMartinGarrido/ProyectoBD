package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Km_Hours_Cost_Service {
    public void add_km_hours_cost(double v_route_km_cost, double v_hours_cost,double v_extra_km_cost, double v_extra_hours_cost) throws SQLException {
        String function = "{call add_km_hours_cost(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setDouble(1, v_route_km_cost);
        preparedFunction.setDouble(2, v_hours_cost);
        preparedFunction.setDouble(3, v_extra_km_cost);
        preparedFunction.setDouble(4,v_extra_hours_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_km_hours_cost(int cod) throws SQLException {
        String function = "{call delete_km_hours_cost(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_km_hours_cost(int cod, double v_route_km_cost, double v_hours_cost,double v_extra_km_cost, double v_extra_hours_cost) throws SQLException {
        String function = "{call update_km_hours_cost(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setDouble(2, v_route_km_cost);
        preparedFunction.setDouble(3, v_hours_cost);
        preparedFunction.setDouble(4, v_extra_km_cost);
        preparedFunction.setDouble(5,v_extra_hours_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
