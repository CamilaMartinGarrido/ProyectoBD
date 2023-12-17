package services;



import dto.Rol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class RoleService {
    public static LinkedList<Rol> getRoles() throws SQLException {
        Rol rol = null;
        LinkedList<Rol> listRol = new LinkedList<>();
        Statement consult = ServicesLocator.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sqlSentence;
        sqlSentence = "SELECT role.* " +
                "FROM  public.role";
        ResultSet result = consult.executeQuery(sqlSentence);
        while (result.next()) {
            if (rol == null) {
                rol = new Rol(rol.getId_role(),
                        rol.getName_role(),
                        rol.getDescription_role());
            }
            listRol.add(rol);
        }
        return listRol;
    }
}
