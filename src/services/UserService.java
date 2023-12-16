package services;
import dto.User;
import java.sql.*;
import java.util.LinkedList;

public class UserService {

    public static int getLoginUser(String user) {
        int rol = 0;
        boolean found = false;
        try {
            LinkedList<User> list = getUsers();
            for (int i = 0; i < list.size() && !found; i++) {
                String userName = list.get(i).getUser_name();
                int rol1 = list.get(i).getId_role();
                if (userName.equalsIgnoreCase(user)) {
                    rol = rol1;
                    found = true;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return rol;
    }

    public static String getLoginUser(String user, String passw) {
        String rol = "";
        try {
            String sqlSentenc = "SELECT role.description_role " +
                    "FROM public.user " +
                    "INNER JOIN public.role ON public.user.id_role = public.role.id_role " +
                    "WHERE public.user.user_name = ? " +
                    "AND public.user.user_password = ? ";
            PreparedStatement prepararedCons = ServicesLocator.getConnection().prepareStatement(sqlSentenc);
            prepararedCons.setString(1, user);
            prepararedCons.setString(2, passw);
            prepararedCons.executeQuery();
            ResultSet result = prepararedCons.getResultSet();
            System.out.print(result);
            while (result.next()) {
                rol = result.getString(1);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
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
            userList.add(new User(result.getString("user_name"), result.getString("user_password"), result.getInt("id_role")));
        }
        return userList;
    }

   /* public static void insertarUsuario(User user) throws SQLException, ClassNotFoundException {

        Connection connection = ServicesLocator.getConnection();
        CallableStatement cs = connection.prepareCall("{call \"usuario_insert\"(?,?,?,?)}");
        cs.setString(1, user.getUser_name());
        String encrip = EncriptShado_MD5.digestMD5(user.getPassword());
        cs.setString(2, encrip);
        cs.setInt(3, user.getId_role());
        cs.setString(4, user.getUser_name());
        cs.executeUpdate();

    }*/


    public static void eliminarUsuario(int user) throws SQLException {

        Connection connection = ServicesLocator.getConnection();
        CallableStatement cs = connection.prepareCall("{call \"usuario_delete\"(?)}");
        cs.setInt(1, user);
        cs.executeUpdate();
    }


}
