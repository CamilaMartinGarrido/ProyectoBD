package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class VehicleService {
    public void add_vehicle(String license_plate, String brand, double luggage_capacity, double with_luggage_capacity, double total_capacity, int year_build) throws SQLException {
        String function = "{call add_vehicle(?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, license_plate);
        preparedFunction.setString(2, brand);
        preparedFunction.setDouble(3, luggage_capacity);
        preparedFunction.setDouble(4, with_luggage_capacity);
        preparedFunction.setDouble(5, total_capacity);
        preparedFunction.setInt(6, year_build);
        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_vehicle(int cod) throws SQLException {
        String function = "{call delete_vehicle(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_vehicle(int cod, String license_plate, String brand, double luggage_capacity, double with_luggage_capacity, double total_capacity, int year_build) throws SQLException {
        String function = "{call update_vehicle(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, license_plate);
        preparedFunction.setString(3, brand);
        preparedFunction.setDouble(4, luggage_capacity);
        preparedFunction.setDouble(5, with_luggage_capacity);
        preparedFunction.setDouble(6, total_capacity);
        preparedFunction.setInt(7, year_build);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
