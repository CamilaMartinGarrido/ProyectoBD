package services;
import dto.Rol;
import dto.User;

import javax.management.relation.Role;
import java.sql.*;
import java.util.LinkedList;

public class UserService {

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

    public static LinkedList<User> getUsers() throws SQLException, ClassNotFoundException {
        LinkedList<User> userList = new LinkedList<>();
        Connection connection = ServicesLocator.getConnection();
        ResultSet result = connection.createStatement().executeQuery(
                "SELECT * " +
                        "FROM public.user");
        while (result.next()) {
            userList.add(new User(result.getInt("id_user"), result.getString("user_name"), result.getString("user_password"), result.getInt("id_role")));
        }
        return userList;
    }

    public static void addUser(User user) throws SQLException{
        Connection connection = ServicesLocator.getConnection();
        CallableStatement cs = connection.prepareCall("{call \"add_user\"(?,?,?)}");
        cs.setString(1, user.getUser_name());
        cs.setString(2, user.getPassword());
        cs.setInt(3, user.getId_role());
        cs.executeUpdate();

    }

    public static void deleteUser(User user) throws SQLException {

        Connection connection = ServicesLocator.getConnection();
        CallableStatement cs = connection.prepareCall("{call \"delete_user\"(?)}");
        cs.setInt(1, user.getId_user());
        cs.executeUpdate();
    }
}
