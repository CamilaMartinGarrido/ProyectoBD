package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class RouteService {
    public void add_route(int id_transp_model, String description_route, double route_cost, double full_ride_cost) throws SQLException {
        String function = "{call add_route(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, id_transp_model);
        preparedFunction.setString(2, description_route);
        preparedFunction.setDouble(3, route_cost);
        preparedFunction.setDouble(4, full_ride_cost);


        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_route(int cod) throws SQLException {
        String function = "{call delete_route(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_route(int cod,String description_route,double route_cost, double full_ride_cost) throws SQLException {
        String function = "{call update_route(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, description_route);
        preparedFunction.setDouble(3, route_cost);
        preparedFunction.setDouble(4, full_ride_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
