package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

import java.util.Date;

public class ContractService {
    public void add_contract(Date start_contract, Date end_contract, Date resolution_contract, String description, String type) throws SQLException {
        String function = "{call add_contract(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setDate(1, (java.sql.Date) start_contract);
        preparedFunction.setDate(2, (java.sql.Date) end_contract);
        preparedFunction.setDate(3, (java.sql.Date) resolution_contract);
        preparedFunction.setString(4, description);
        preparedFunction.setString(5, type);
        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_contract(int cod) throws SQLException {
        String function = "{call delete_contract(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_contract(int cod, String description) throws SQLException {
        String function = "{call update_contract(?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, description);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
