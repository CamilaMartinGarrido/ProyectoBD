package services;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class RoomService {
    public void add_room(String room_number, String room_type, double room_cost) throws SQLException {
        String function = "{call add_room(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, room_number);
        preparedFunction.setString(2, room_type);
        preparedFunction.setDouble(3, room_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_room(int cod) throws SQLException {
        String function = "{call delete_room(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_room(int cod, String room_number, String room_type, double room_cost) throws SQLException {
        String function = "{call update_room(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setString(2, room_number);
        preparedFunction.setString(3, room_type);
        preparedFunction.setDouble(4, room_cost);

        preparedFunction.execute();

        preparedFunction.close();
    }
}
