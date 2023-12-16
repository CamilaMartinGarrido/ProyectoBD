package services;

import dto.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class RoleService {
    public static LinkedList<Role> getRoles() throws SQLException {
        Role rol = null;
        LinkedList<Role> listRol = new LinkedList<>();
        Statement consult = ServicesLocator.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sqlSentence;
        sqlSentence = "SELECT role.* " +
                "FROM  public.role";
        ResultSet result = consult.executeQuery(sqlSentence);
        while (result.next()) {
            if (rol == null) {
                rol = new Role(rol.getId_role(),
                        rol.getName_role(),
                        rol.getDescription_role());
            }
            listRol.add(rol);
        }
        return listRol;
    }
}
