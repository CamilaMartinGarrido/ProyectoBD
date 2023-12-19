package services;
import dto.Km_Cost;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class KmCostService {
    //List of Km_Costs
    public static LinkedList<Km_Cost> getKmCosts() throws SQLException {
        LinkedList<Km_Cost> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT * " +
                        "FROM public.transportation_model AS t" +
                        "INNER JOIN public.km_cost AS k" +
                        "ON t.id_transportation = k.id_transportation"
        );
        while (res.next()) {
            list.add(new Km_Cost(
                    res.getInt("id_transp_model"),
                    res.getString("type_transp_model"),
                    res.getString("description_tm"),
                    res.getDouble("km_cost"),
                    res.getDouble("full_ride_km_cost"),
                    res.getDouble("waiting_hours_cos")
            ));
        }
        return list;
    }
    //Add
    public void add_km_cost(int v_id_transp_model, double v_km_cost, double v_full_ride_cost, double v_waiting_hours_cost) throws SQLException {
        String function = "{call add_km_cost(?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, v_id_transp_model);
        preparedFunction.setDouble(2, v_km_cost);
        preparedFunction.setDouble(3, v_full_ride_cost);
        preparedFunction.setDouble(4, v_waiting_hours_cost);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_km_cost(int cod) throws SQLException {
        String function = "{call delete_km_cost(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Update
    public void update_km_cost(int cod, double v_km_cost, double v_full_ride_cost, double v_waiting_hours_cost) throws SQLException {
        String function = "{call update_km_cost(?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setDouble(2, v_km_cost);
        preparedFunction.setDouble(3, v_full_ride_cost);
        preparedFunction.setDouble(4, v_waiting_hours_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
