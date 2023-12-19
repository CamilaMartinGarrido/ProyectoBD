package services;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class HotelRoomSeasonService {
    //Add
    public void add_hotel_room_season(int v_fk_hotel_room_season_hotel, int v_fk_hotel_room_season_room, int v_fk_hotel_room_season_season) throws SQLException {
        String function = "{call add_hotel_room_season(?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, v_fk_hotel_room_season_hotel);
        preparedFunction.setInt(2, v_fk_hotel_room_season_room);
        preparedFunction.setInt(3, v_fk_hotel_room_season_season);

        preparedFunction.execute();

        preparedFunction.close();
    }
    //Delete
    public void delete_hotel_room_season(int cod) throws SQLException {
        String function = "{call delete_hotel_room_season(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();

        preparedFunction.close();

    }
    //Update
    public void update_hotel_room_season(int cod, int v_fk_hotel_room_season_hotel, int v_fk_hotel_room_season_room, int v_fk_hotel_room_season_season) throws SQLException {
        String function = "{call update_hotel_room_season(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setInt(2, v_fk_hotel_room_season_hotel);
        preparedFunction.setInt(3, v_fk_hotel_room_season_season);
        preparedFunction.setInt(4, v_fk_hotel_room_season_season);

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
}
