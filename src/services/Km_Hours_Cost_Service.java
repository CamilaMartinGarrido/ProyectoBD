package services;
import dto.Km_Hours_Cost;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Km_Hours_Cost_Service {
    //List of Km_Hours_Costs
    public static LinkedList<Km_Hours_Cost> getKmHoursCosts() throws SQLException {
        LinkedList<Km_Hours_Cost> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT * " +
                        "FROM public.transportation_model AS t" +
                        "INNER JOIN public.km_hours_cost AS kh" +
                        "ON t.id_transportation = kh.id_transportation"
        );
        while (res.next()) {
            list.add(new Km_Hours_Cost(
                    res.getInt("id_transp_model"),
                    res.getString("type_transp_model"),
                    res.getString("description_tm"),
                    res.getDouble("route_km_cost"),
                    res.getDouble("hours_cost"),
                    res.getDouble("extra_km_cost"),
                    res.getDouble("extras_hours_cost")
            ));
        }
        return list;
    }
    //Add
    public void add_km_hours_cost(int v_id_transp_model, double v_route_km_cost, double v_hours_cost,double v_extra_km_cost, double v_extra_hours_cost) throws SQLException {
        String function = "{call add_km_hours_cost(?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, v_id_transp_model);
        preparedFunction.setDouble(2, v_route_km_cost);
        preparedFunction.setDouble(3, v_hours_cost);
        preparedFunction.setDouble(4, v_extra_km_cost);
        preparedFunction.setDouble(5,v_extra_hours_cost);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_km_hours_cost(int cod) throws SQLException {
        String function = "{call delete_km_hours_cost(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Update
    public void update_km_hours_cost(int cod, double v_route_km_cost, double v_hours_cost,double v_extra_km_cost, double v_extra_hours_cost) throws SQLException {
        String function = "{call update_km_hours_cost(?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setDouble(2, v_route_km_cost);
        preparedFunction.setDouble(3, v_hours_cost);
        preparedFunction.setDouble(4, v_extra_km_cost);
        preparedFunction.setDouble(5,v_extra_hours_cost);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
}
