package services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hotel_Room_Season_Service {
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

    public void delete_hotel_room_season(int cod) throws SQLException {
        String function = "{call delete_hotel_room_season(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_hotel_room_season(int cod, int v_fk_hotel_room_season_hotel, int v_fk_hotel_room_season_room, int v_fk_hotel_room_season_season) throws SQLException {
        String function = "{call update_hotel_room_season(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, cod);
        preparedFunction.setInt(2, v_fk_hotel_room_season_hotel);
        preparedFunction.setInt(3, v_fk_hotel_room_season_season);
        preparedFunction.setInt(4, v_fk_hotel_room_season_season);


        preparedFunction.execute();

        preparedFunction.close();
    }

    public static int getIdHotel_Room_Season() throws SQLException,ClassNotFoundException{
        java.sql.Connection connection = ServicesLocator.getConnection();
        int cod=-1;
        String sql = "SELECT * FROM hotel_room_season AS h" +
                "ORDER BY h.id_hotel_room_season DESC" +
                "LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        ResultSet result = statement.getResultSet();
        cod = result.getInt(1);
        return cod;
    }
}
