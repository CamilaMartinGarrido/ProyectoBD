package services;
import dto.Transportation;

import java.sql.*;
import java.util.LinkedList;

public class TransportationService {

    public static LinkedList<Transportation> getBorrower() throws SQLException {
        LinkedList<Transportation> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT transportation.*" +
                        "FROM public.transportation"
        );
        while (res.next()) {
            list.add(new Transportation(
                    res.getInt("id_transportation"),
                    res.getInt("id_transp_model"),
                    res.getString("borrower"))
            );
        }
        return list;
    }
    //Add
    public void add_transportation(int fk_transportation_model, int fk_transportation_vehicle, String borrower ) throws SQLException {
        String function = "{call add_transportation(?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, fk_transportation_model);
        preparedFunction.setInt(2, fk_transportation_vehicle);
        preparedFunction.setString(3, borrower);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_transportation(int cod) throws SQLException {
        String function = "{call delete_transportation(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Update
    public void update_transportation(int cod,int fk_transportation_model, int fk_transportation_vehicle, String borrower ) throws SQLException {
        String function = "{call update_transportation(?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setInt(2, fk_transportation_model);
        preparedFunction.setInt(3, fk_transportation_vehicle);
        preparedFunction.setString(4, borrower);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
}
