package services;
import dto.User;
import java.sql.*;
import java.util.LinkedList;

public class UserService {
    //Login
    public static int getLoginUser(String user, String passw) {
        int rol = -1;
        try {
            String sqlSentenc = "{? = call find_user(?, ?)}";
            CallableStatement callableStatement = ServicesLocator.getConnection().prepareCall(sqlSentenc);
            callableStatement.registerOutParameter(1, Types.INTEGER); // Este es el parámetro de retorno
            callableStatement.setString(2, user); // Parámetro 2 en la llamada a la función
            callableStatement.setString(3, passw); // Parámetro 3 en la llamada a la función
            callableStatement.execute();
            rol = callableStatement.getInt(1); // Obtenemos el valor del parámetro de retorno
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rol;
    }
    //List of Users
    public static LinkedList<User> getUsers() throws SQLException, ClassNotFoundException {
        LinkedList<User> userList = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet res = connection.createStatement().executeQuery(
                "SELECT * " +
                        "FROM public.user");
        while (res.next()) {
            userList.add(new User(
                    res.getInt("id_user"),
                    res.getString("user_name"),
                    res.getString("user_password"),
                    res.getInt("id_role")));
        }
        return userList;
    }

    public static boolean find(User u) {
        return true;
    }


    /*
    //Add
    public static void addUser(User user) throws SQLException{
        Connection connection = ServicesLocator.getConnection();
        CallableStatement cs = connection.prepareCall("{call add_user(?,?,?)}");
        cs.setString(1, user.getUser_name());
        cs.setString(2, user.getPassword());
        cs.setInt(3, user.getId_role());
        cs.executeUpdate();
    }
    //Delete
    public static void deleteUser(User user) throws SQLException {
        Connection connection = ServicesLocator.getConnection();
        CallableStatement cs = connection.prepareCall("{call \"delete_user\"(?)}");
        cs.setInt(1, user.getId_user());
        cs.executeUpdate();
    }
    */


    //Add
    public static void add_user(User user) throws SQLException {
        String function = "{call add_user(?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setString(1, user.getUser_name());
        preparedFunction.setString(1, user.getPassword());
        preparedFunction.setDouble(1, user.getId_role());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Delete
    public static void delete_user(User user) throws SQLException {
        String function = "{call delete_user(?)";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, user.getId_user());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
    //Update
    public static void update_user(User user) throws SQLException {
        String function = "{call update_user(?,?,?,?)}";
        Connection connection = ServicesLocator.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);

        preparedFunction.setInt(1, user.getId_user());
        preparedFunction.setString(1, user.getUser_name());
        preparedFunction.setString(1, user.getPassword());
        preparedFunction.setInt(1, user.getId_role());

        preparedFunction.executeQuery();

        preparedFunction.close();
    }
}
