package services;

import dto.Hotel;

import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Hotel_Service {
    public static LinkedList<Hotel> getHotels() throws SQLException {
        LinkedList<Hotel> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT hotel.*" +
                        "FROM public.hotel"
        );
        while (res.next()) {
            list.add(new Hotel(
                    res.getInt("id_hotel"),
                    res.getString("name_hotel"),
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
                    res.getString("location_hotel"),
                    res.getString("business_model")));
        }
        return list;
    }
    //Add
    public void add_Hotel(Hotel h) throws SQLException {
        String function = "{ call add_hotel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, h.getName_hotel());
        preparedFunction.setString(2, h.getChain_hotel());
        preparedFunction.setString(3, h.getCategory_hotel());
        preparedFunction.setString(4, h.getAddress_hotel());
        preparedFunction.setString(5, h.getProvince_hotel());
        preparedFunction.setBoolean(6, h.isIs_active());
        preparedFunction.setDate(7, (Date) h.getDate_hotel());
        preparedFunction.setString(8, h.getPhone());
        preparedFunction.setString(9, h.getFax());
        preparedFunction.setString(10, h.getEmail());
        preparedFunction.setDouble(11, h.getDistance_to_city());
        preparedFunction.setDouble(12, h.getDistance_to_airport());
        preparedFunction.setInt(13, h.getRoom_count());
        preparedFunction.setInt(14, h.getFloor_count());
        preparedFunction.setString(15, h.getLocation_hotel());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }

    public void delete_Hotel(Hotel h ) throws SQLException {
        String function = "{ call delete_hotel(?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, h.getId_hotel());
        preparedFunction.execute();
        preparedFunction.close();
    }

    public void update_Hotel(Hotel h) throws SQLException {
        String function = "{ call update_hotel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, h.getId_hotel());
        preparedFunction.setString(2, h.getName_hotel());
        preparedFunction.setString(3, h.getChain_hotel());
        preparedFunction.setString(4, h.getCategory_hotel());
        preparedFunction.setString(5, h.getAddress_hotel());
        preparedFunction.setString(6, h.getProvince_hotel());
        preparedFunction.setBoolean(7, h.isIs_active());
        preparedFunction.setDate(8, (Date) h.getDate_hotel());
        preparedFunction.setString(9, h.getPhone());
        preparedFunction.setString(10, h.getFax());
        preparedFunction.setString(11, h.getEmail());
        preparedFunction.setDouble(12, h.getDistance_to_city());
        preparedFunction.setDouble(13, h.getDistance_to_airport());
        preparedFunction.setInt(14, h.getRoom_count());
        preparedFunction.setInt(15, h.getFloor_count());
        preparedFunction.setString(16, h.getLocation_hotel());
        preparedFunction.execute();
        preparedFunction.close();

    }
    public boolean find(Hotel hotel) throws SQLException {
        LinkedList<Hotel> list = getHotels();
        Iterator<Hotel> iter = list.iterator();
        boolean aux = false;
        while(iter.hasNext() && !aux ){
            Hotel h = iter.next();
            if(h.getId_hotel()== hotel.getId_hotel()){
                aux = true;
            }
        }
        return aux;
    }
}
