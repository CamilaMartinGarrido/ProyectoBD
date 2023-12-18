package services;

import dto.Contract;

import java.sql.*;
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

    public void add_contract_hotel(Contract c, int id_H) throws SQLException {
        String function = "{call add_contract(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setTimestamp(1, c.getStart_contract());
        preparedFunction.setTimestamp(2, c.getEnd_contract());
        preparedFunction.setTimestamp(3, c.getResolution_contract());
        preparedFunction.setString(4, c.getDescription_contract());
        preparedFunction.setString(5, c.getContract_type());
        preparedFunction.setNull(6, Types.INTEGER);
        preparedFunction.setInt(7, id_H);
        preparedFunction.execute();
        preparedFunction.close();
    }

    public void add_contract_Transport(Contract c, int id_T) throws SQLException {
        String function = "{call add_contract(?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setTimestamp(1, c.getStart_contract());
        preparedFunction.setTimestamp(2, c.getEnd_contract());
        preparedFunction.setTimestamp(3, c.getResolution_contract());
        preparedFunction.setString(4, c.getDescription_contract());
        preparedFunction.setString(5, c.getContract_type());
        preparedFunction.setInt(6, id_T);
        preparedFunction.execute();
        preparedFunction.close();
    }

    public void add_contract_Service(Contract c, int id_D) throws SQLException {
        String function = "{call add_contract(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setTimestamp(1, c.getStart_contract());
        preparedFunction.setTimestamp(2, c.getEnd_contract());
        preparedFunction.setTimestamp(3, c.getResolution_contract());
        preparedFunction.setString(4, c.getDescription_contract());
        preparedFunction.setString(5, c.getContract_type());
        preparedFunction.setNull(6, Types.INTEGER);
        preparedFunction.setNull(7, Types.INTEGER);
        preparedFunction.setInt(8, id_D);
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
