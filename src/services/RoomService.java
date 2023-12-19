package services;

import dto.Room;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class RoomService {
    public static LinkedList<Room> getRooms() throws SQLException {
        LinkedList<Room> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT room.*" +
                        "FROM public.room"
        );
        while (res.next()) {
            list.add(new Room(
                    res.getInt("id_room"),
                    res.getInt("room_number"),
                    res.getString("room_type"),
                    res.getDouble("room_cost"),
                    res.getDouble("room_surcharge"),
                    res.getInt("id_plan")
            ));
        }
        return list;
    }
    //Add
    public void add_room(Room room) throws SQLException {
        String function = "{call add_room(?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, room.getRoom_number());
        preparedFunction.setString(1, room.getRoom_type());
        preparedFunction.setDouble(1, room.getRoom_cost());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public void delete_room(Room room) throws SQLException {
        String function = "{call delete_room(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, room.getId_room());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Update
    public void update_room(Room room) throws SQLException {
        String function = "{call update_room(?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, room.getId_room());
        preparedFunction.setInt(1, room.getRoom_number());
        preparedFunction.setString(1, room.getRoom_type());
        preparedFunction.setDouble(1, room.getRoom_cost());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
}
