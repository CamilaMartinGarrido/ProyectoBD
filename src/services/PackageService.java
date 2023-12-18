package services;

import dto.Package;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class PackageService {

    public static LinkedList<Package> getPackages()throws SQLException{
        LinkedList<Package>list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT package.*" +
                        "FROM public.package"
        );
        while(res.next()){
            list.add(new Package( res.getInt("id_package"),res.getString( "promotional_name"),
            res.getInt( "days_count"),
            res.getInt( "nights_count"),
            res.getInt( "pax_count"),
            res.getDouble( "total_hotel_cost"),
            res.getDouble("hotel_airport_ride_cost"),
            res.getDouble( "total_transportation_cost"),
            res.getDouble( "total_package_cost")));
        }
        return list;
    }
    public void add_package(Package p ) throws SQLException {
        String function = "{call add_package(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, p.getPromotional_name());
        preparedFunction.setInt(2, p.getDays_count());
        preparedFunction.setInt(3, p.getNights_count());
        preparedFunction.setInt(4, p.getPax_count());
        preparedFunction.setDouble(5, p.getTotal_hotel_cost());
        preparedFunction.setDouble(6, p.getHotel_airport_ride_cost());
        preparedFunction.setDouble(7, p.getTotal_transportation_cost());
        preparedFunction.setDouble(8, p.getTotal_package_cost());
        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_package(Package p) throws SQLException {
        String function = "{call delete_package(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, p.getId_package());
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_package(Package p ) throws SQLException {
        String function = "{call update_package(?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, p.getId_package());
        preparedFunction.setString(2, p.getPromotional_name());
        preparedFunction.setInt(3, p.getDays_count());
        preparedFunction.setInt(4, p.getNights_count());
        preparedFunction.setInt(5, p.getPax_count());
        preparedFunction.setDouble(6, p.getTotal_hotel_cost());
        preparedFunction.setDouble(7, p.getHotel_airport_ride_cost());
        preparedFunction.setDouble(8, p.getTotal_transportation_cost());
        preparedFunction.setDouble(9, p.getTotal_package_cost());

        preparedFunction.execute();

        preparedFunction.close();
    }
}
