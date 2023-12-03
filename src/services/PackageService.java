package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class PackageService {
    public void add_package(String promotional_name, int days_count, int nights_count, int pax_count, double total_hotel_cost, double hotel_airport_ride_cost, double total_transportation_cost, double total_package_cost) throws SQLException {
        String function = "{call add_package(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, promotional_name);
        preparedFunction.setInt(2, days_count);
        preparedFunction.setInt(3, nights_count);
        preparedFunction.setInt(4, pax_count);
        preparedFunction.setDouble(5, total_hotel_cost);
        preparedFunction.setDouble(6, hotel_airport_ride_cost);
        preparedFunction.setDouble(7, total_transportation_cost);
        preparedFunction.setDouble(8, total_package_cost);
        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_package(int cod) throws SQLException {
        String function = "{call delete_package(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_package(int cod, String promotional_name, int days_count, int nights_count, int pax_count, double total_hotel_cost, double hotel_airport_ride_cost, double total_transportation_cost, double total_package_cost) throws SQLException {
        String function = "{call update_package(?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, promotional_name);
        preparedFunction.setInt(3, days_count);
        preparedFunction.setInt(4, nights_count);
        preparedFunction.setInt(5, pax_count);
        preparedFunction.setDouble(6, total_hotel_cost);
        preparedFunction.setDouble(7, hotel_airport_ride_cost);
        preparedFunction.setDouble(8, total_transportation_cost);
        preparedFunction.setDouble(9, total_package_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
