package services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class TransportationService {

    public static LinkedList<String> getBorrower() throws SQLException {
        LinkedList<String> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT transportation.borrower" +
                        "FROM public.transportation"
        );
        while (res.next()) {
            list.add(res.getString("borrower"));
        }
        return list;
    }

    public void add_transportation(int fk_transportation_model, int fk_transportation_vehicle, String borrower ) throws SQLException {
        String function = "{call add_transportation(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, fk_transportation_model);
        preparedFunction.setInt(2, fk_transportation_vehicle);
        preparedFunction.setString(3, borrower);


        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_transportation(int cod) throws SQLException {
        String function = "{call delete_transportation(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_transportation(int cod,int fk_transportation_model, int fk_transportation_vehicle, String borrower ) throws SQLException {
        String function = "{call update_transportation(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setInt(2, fk_transportation_model);
        preparedFunction.setInt(3, fk_transportation_vehicle);
        preparedFunction.setString(4, borrower);




        preparedFunction.execute();

        preparedFunction.close();
    }
}
