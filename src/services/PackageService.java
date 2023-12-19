package services;
import dto.Package;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

public class PackageService {
    //List of Packages
    public static LinkedList<Package> getPackages()throws SQLException{
        LinkedList<Package>list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT package.*" +
                        "FROM public.package"
        );
        while(res.next()){
            list.add(new Package(
                    res.getInt("id_package"),
                    res.getString( "promotional_name"),
                    res.getInt( "days_count"),
                    res.getInt( "nights_count"),
                    res.getInt( "pax_count"),
                    res.getDouble("hotel_airport_ride_cost"),
                    res.getDouble("percent_profit")));
        }
        return list;
    }
    //Add
    public void add_package(Package p ) throws SQLException {
        String function = "{call add_package(?,?,?,?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, p.getPromotional_name());
        preparedFunction.setInt(2, p.getDays_count());
        preparedFunction.setInt(3, p.getNights_count());
        preparedFunction.setInt(4, p.getPax_count());
        preparedFunction.setDouble(5, p.getTotal_hotel_cost());
        preparedFunction.setDouble(6, p.getHotel_airport_ride_cost());
        preparedFunction.setDouble(7, p.getTotal_transportation_cost());
        preparedFunction.setDouble(8, p.getTotal_package_cost());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_package(Package p) throws SQLException {
        String function = "{call delete_package(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, p.getId_package());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Update
    public void update_package(Package p ) throws SQLException {
        String function = "{call update_package(?,?,?,?,?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
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

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Find
    public boolean find(Package p) throws SQLException {
        LinkedList<Package> packages = getPackages();
        Iterator<Package> iter = packages.iterator();
        boolean aux = false;
        while (iter.hasNext() && !aux){
            Package pa = iter.next();
            if(pa.getId_package() == p.getId_package()){
                aux = true;
            }
        }
        return aux;
    }
}