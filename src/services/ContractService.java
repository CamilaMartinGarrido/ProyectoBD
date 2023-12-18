package services;

import dto.Contract;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ContractService {

    public static LinkedList<Contract> getContracts() throws SQLException {
        LinkedList<Contract> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT contract.*" +
                        "FROM public.contract"
        );
        while (res.next()) {
            list.add(new Contract(res.getTimestamp("start_contract"),
            res.getTimestamp("end_contract"),
            res.getTimestamp("resolution_contract"),
            res.getString("description_contract"),
            res.getString("contract_type")));
        }
        return list;
    }
   /* public static LinkedList<Contract_Hotel> getHotelContracts() throws SQLException {
        LinkedList<Contract_Hotel> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT contract.*" +
                        "FROM public.contract"
        );
        while (res.next()) {
            list.add(new Contract_Hotel(res.getTimestamp("start_contract"),
                    res.getTimestamp("end_contract"),
                    res.getTimestamp("resolution_contract"),
                    res.getString("description_contract"),
                    res.getString("contract_type")));
        }
        return list;
    }*/
    public void add_contract(Contract c) throws SQLException {
        String function = "{call add_contract(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setTimestamp(1, c.getStart_contract());
        preparedFunction.setTimestamp(2, c.getEnd_contract());
        preparedFunction.setTimestamp(3, c.getResolution_contract());
        preparedFunction.setString(4, c.getDescription_contract());
        preparedFunction.setString(5, c.getContract_type());
        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_contract(Contract c) throws SQLException {
        String function = "{call delete_contract(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, c.getId_contract());
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_contract(Contract c) throws SQLException {
        String function = "{call update_contract(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, c.getId_contract());
        preparedFunction.setString(2, c.getDescription_contract());

        preparedFunction.execute();

        preparedFunction.close();
    }
}
