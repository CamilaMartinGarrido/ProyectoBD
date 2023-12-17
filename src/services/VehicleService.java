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


    public void add_vehicle(Vehicle v) throws SQLException {
        String function = "{call add_vehicle(?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, v.getLicense_plate());
        preparedFunction.setString(1, v.getBrand());
        preparedFunction.setDouble(1, v.getLuggage_capacity());
        preparedFunction.setDouble(1, v.getWith_luggage_capacity());
        preparedFunction.setDouble(1, v.getTotal_capacity());
        preparedFunction.setInt(1, v.getYear_build());
        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_vehicle(Vehicle v) throws SQLException {
        String function = "{call delete_vehicle(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, v.getId_vehicle());
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_vehicle(Vehicle v) throws SQLException {
        String function = "{call update_vehicle(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, v.getId_vehicle());
        preparedFunction.setString(1, v.getLicense_plate());
        preparedFunction.setString(1, v.getBrand());
        preparedFunction.setDouble(1, v.getLuggage_capacity());
        preparedFunction.setDouble(1, v.getWith_luggage_capacity());
        preparedFunction.setDouble(1, v.getTotal_capacity());
        preparedFunction.setInt(1, v.getYear_build());

        preparedFunction.execute();

        preparedFunction.close();
    }
}
