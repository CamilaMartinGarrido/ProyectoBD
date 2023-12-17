package services;

import dto.Contract;
import dto.Hotel;

import java.sql.*;
import java.util.LinkedList;

public class HotelService {
    public static LinkedList<Hotel> getHotels() throws SQLException {
        LinkedList<Hotel> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT hotel.*" +
                        "FROM public.hotel"
        );
        while (res.next()) {
            list.add(new Hotel(res.getString("name_hotel"),
                    res.getString("chain_hotel"),
                    res.getString("category_hotel"),
                    res.getString("address_hotel"),
                    res.getString("province_hotel"),
                    res.getBoolean("is_active"),
                    res.getTimestamp("date_hotel"),
                    res.getString("phone"),
                    res.getString("fax"),
                    res.getString("email"),
                    res.getDouble("distance_to_city"),
                    res.getDouble("distance_to_airport"),
                    res.getInt("room_count"),
                    res.getInt("floor_count"),
                    res.getString("location_hotel")));
        }
        return list;
    }




    public void add_Hotel(Hotel h) throws SQLException {
        String function = "{ call add_hotel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, h.getName_hotel());
        preparedFunction.setString(1, h.getChain_hotel());
        preparedFunction.setString(1, h.getCategory_hotel());
        preparedFunction.setString(1, h.getAddress_hotel());
        preparedFunction.setString(1, h.getProvince_hotel());
        preparedFunction.setBoolean(1, h.isIs_active());
        preparedFunction.setDate(1, (Date) h.getDate_hotel());
        preparedFunction.setString(1, h.getPhone());
        preparedFunction.setString(1, h.getFax());
        preparedFunction.setString(1, h.getEmail());
        preparedFunction.setDouble(1, h.getDistance_to_city());
        preparedFunction.setDouble(1, h.getDistance_to_airport());
        preparedFunction.setInt(1, h.getRoom_count());
        preparedFunction.setInt(1, h.getFloor_count());
        preparedFunction.setString(1, h.getLocation_hotel());
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void delete_Hotel(Hotel h ) throws SQLException {
        String function = "{ call delete_hotel(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, h.getId_hotel());
        preparedFunction.execute();
        preparedFunction.close();
    }

    public void update_Hotel(Hotel h) throws SQLException {
        String function = "{ call update_hotel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, h.getId_hotel());
        preparedFunction.setString(1, h.getName_hotel());
        preparedFunction.setString(1, h.getChain_hotel());
        preparedFunction.setString(1, h.getCategory_hotel());
        preparedFunction.setString(1, h.getAddress_hotel());
        preparedFunction.setString(1, h.getProvince_hotel());
        preparedFunction.setBoolean(1, h.isIs_active());
        preparedFunction.setDate(1, (Date) h.getDate_hotel());
        preparedFunction.setString(1, h.getPhone());
        preparedFunction.setString(1, h.getFax());
        preparedFunction.setString(1, h.getEmail());
        preparedFunction.setDouble(1, h.getDistance_to_city());
        preparedFunction.setDouble(1, h.getDistance_to_airport());
        preparedFunction.setInt(1, h.getRoom_count());
        preparedFunction.setInt(1, h.getFloor_count());
        preparedFunction.setString(1, h.getLocation_hotel());
        preparedFunction.execute();
        preparedFunction.close();

    }
}
