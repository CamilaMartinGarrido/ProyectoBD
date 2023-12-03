package services;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

public class HotelService {
    public void add_Hotel(String v_name_hotel, String v_chain_hotel, String v_category_hotel, String v_address_hotel, String v_province_hotel, Boolean v_is_active, Date v_date_hotel, String v_phone, String v_fax, String v_email,
                          Double v_distance_to_city, Double v_distance_to_airport, Integer v_room_count, Integer v_floor_count, String v_location_hotel) throws SQLException {
        String function = "{ call add_hotel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, v_name_hotel);
        preparedFunction.setString(2, v_chain_hotel);
        preparedFunction.setString(3, v_category_hotel);
        preparedFunction.setString(4, v_address_hotel);
        preparedFunction.setString(5, v_province_hotel);
        preparedFunction.setBoolean(6, v_is_active);
        preparedFunction.setDate(7, v_date_hotel);
        preparedFunction.setString(8, v_phone);
        preparedFunction.setString(9, v_fax);
        preparedFunction.setString(10, v_email);
        preparedFunction.setDouble(11, v_distance_to_city);
        preparedFunction.setDouble(12, v_distance_to_airport);
        preparedFunction.setInt(13, v_room_count);
        preparedFunction.setInt(14, v_floor_count);
        preparedFunction.setString(15, v_location_hotel);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void delete_Hotel(Integer cod) throws SQLException {
        String function = "{ call delete_hotel(?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();
    }

    public void update_Hotel(Integer cod, String v_name_hotel, String v_chain_hotel, String v_category_hotel, String v_address_hotel, String v_province_hotel, Boolean v_is_active, Date v_date_hotel, String v_phone, String v_fax, String v_email,
                             Double v_distance_to_city, Double v_distance_to_airport, Integer v_room_count, Integer v_floor_count, String v_location_hotel) throws SQLException {
        String function = "{ call update_hotel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, v_name_hotel);
        preparedFunction.setString(3, v_chain_hotel);
        preparedFunction.setString(4, v_category_hotel);
        preparedFunction.setString(5, v_address_hotel);
        preparedFunction.setString(6, v_province_hotel);
        preparedFunction.setBoolean(7, v_is_active);
        preparedFunction.setDate(8, v_date_hotel);
        preparedFunction.setString(9, v_phone);
        preparedFunction.setString(10, v_fax);
        preparedFunction.setString(11, v_email);
        preparedFunction.setDouble(12, v_distance_to_city);
        preparedFunction.setDouble(13, v_distance_to_airport);
        preparedFunction.setInt(14, v_room_count);
        preparedFunction.setInt(15, v_floor_count);
        preparedFunction.setString(16, v_location_hotel);
        preparedFunction.execute();
        preparedFunction.close();

    }
}
