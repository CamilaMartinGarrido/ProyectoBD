package services;



import dto.Vehicle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class VehicleService {

    public static LinkedList<Vehicle> getVehicles() throws SQLException {
        LinkedList<Vehicle> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT vehicle.*" +
                        "FROM public.vehicle ");
        while (res.next()){
            list.add(new Vehicle(res.getInt("id_vehicle"),res.getString("license_plate"),res.getString("brand"),res.getDouble("luggage_capacity")
            ,res.getDouble("with_luggage_capacity"),res.getDouble("total_capacity"),res.getInt("year_build")));
        }
        return list;
    }


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
