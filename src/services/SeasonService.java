package services;



import dto.Season;

import java.sql.*;
import java.util.LinkedList;

public class SeasonService {

    public static LinkedList<Season> getSeason() throws SQLException {
        LinkedList<Season> list = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT season.*" +
                        "FROM public.season"
        );
        while (res.next()) {
            list.add(new Season(res.getInt("id_season"), res.getString("name_season"),
                    res.getTimestamp("start_season"),
                    res.getTimestamp("end_season"),
                    res.getString("description_season")

            ));
        }
        return list;
    }

    public void add_season(Season s) throws SQLException {
        String function = "{call add_season(?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, s.getName_season());
        preparedFunction.setTimestamp(1, (Timestamp) s.getStart_season());
        preparedFunction.setTimestamp(1, (Timestamp) s.getEnd_season());
        preparedFunction.setString(1, s.getDescription_season());


        preparedFunction.execute();

        preparedFunction.close();
    }

    public void delete_season(Season s) throws SQLException {
        String function = "{call delete_season(?)";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, s.getId_season());
        preparedFunction.execute();
        preparedFunction.close();

    }

    public void update_season(Season s) throws SQLException {
        String function = "{call update_season(?,?,?,?,?)}";
        java.sql.Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, s.getId_season());
        preparedFunction.setString(1, s.getName_season());
        preparedFunction.setTimestamp(1, (Timestamp) s.getStart_season());
        preparedFunction.setTimestamp(1, (Timestamp) s.getEnd_season());
        preparedFunction.setString(1, s.getDescription_season());


        preparedFunction.execute();

        preparedFunction.close();
    }
}
