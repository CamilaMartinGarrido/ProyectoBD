package connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static java.sql.Connection connection;
    public DataBaseConnection (String serverAddress, String database, String user,String pass ) throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        String url =  "jdbc:postgresql://" + serverAddress + ":5433/"+ database;
        connection = DriverManager.getConnection(url, user, pass);
    }
    public java.sql.Connection getConnection() {
        return connection;
    }
}
