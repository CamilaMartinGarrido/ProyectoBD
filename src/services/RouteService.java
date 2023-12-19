package services;
import dto.Route;

import java.sql.*;
import java.util.LinkedList;

public class RouteService {
    //List of Routes
    public static LinkedList<Route> getRoutes() throws SQLException {
        LinkedList<Route> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT * " +
                        "FROM public.transportation_model AS t" +
                        "INNER JOIN public.route AS r" +
                        "ON t.id_transportation = r.id_transportation"
        );
        while (res.next()) {
            list.add(new Route(
                    res.getInt("id_transp_model"),
                    res.getString("type_transp_model"),
                    res.getString("description_tm"),
                    res.getString("description_route"),
                    res.getDouble("route_cost"),
                    res.getDouble("full_ride_cost")
            ));
        }
        return list;
    }
    //Add
    public void add_route(int id_transp_model, String description_route, double route_cost, double full_ride_cost) throws SQLException {
        String function = "{call add_route(?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, id_transp_model);
        preparedFunction.setString(2, description_route);
        preparedFunction.setDouble(3, route_cost);
        preparedFunction.setDouble(4, full_ride_cost);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_route(int cod) throws SQLException {
        String function = "{call delete_route(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Update
    public void update_route(int cod,String description_route,double route_cost, double full_ride_cost) throws SQLException {
        String function = "{call update_route(?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, description_route);
        preparedFunction.setDouble(3, route_cost);
        preparedFunction.setDouble(4, full_ride_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
