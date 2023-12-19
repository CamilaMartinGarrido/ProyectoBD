package services;
import dto.Contract;
import java.sql.*;
import java.util.LinkedList;

public class ContractService {
    //List of Contracts
    public static LinkedList<Contract> getContracts() throws SQLException {
        LinkedList<Contract> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT contract.*" +
                        "FROM public.contract"
        );
        while (res.next()) {
            list.add(new Contract(
                    res.getTimestamp("start_contract"),
                    res.getTimestamp("end_contract"),
                    res.getTimestamp("resolution_contract"),
                    res.getString("description_contract"),
                    res.getInt("id_transportation"),
                    res.getInt("id_hotel_room_season"),
                    res.getInt("id_activity")));
        }
        return list;
    }
    //Add
    public void add_contract(Contract c) throws SQLException {
        String function = "{call add_contract(?,?,?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setTimestamp(1, c.getStart_contract());
        preparedFunction.setTimestamp(2, c.getEnd_contract());
        preparedFunction.setTimestamp(3, c.getResolution_contract());
        preparedFunction.setString(4, c.getDescription_contract());
        preparedFunction.setInt(5, c.getId_transportation());
        preparedFunction.setInt(6, c.getId_hotel_room_season());
        preparedFunction.setInt(7,c.getId_activity());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_contract(Contract c) throws SQLException {
        String function = "{call delete_contract(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, c.getId_contract());

        preparedFunction.executeQuery();

        preparedFunction.close();

    }
    //Update
    public void update_contract(Contract c) throws SQLException {
        String function = "{call update_contract(?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, c.getId_contract());
        preparedFunction.setString(2, c.getDescription_contract());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
}
