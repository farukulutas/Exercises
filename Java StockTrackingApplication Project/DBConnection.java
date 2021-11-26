
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String CONN = "jdbc:mysql://localhost/stoktakipdb?serverTimezone=UTC";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(CONN, USERNAME, PASSWORD); 
    }
}
