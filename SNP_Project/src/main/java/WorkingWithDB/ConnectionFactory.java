package WorkingWithDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "1997";
    private static Connection connection = null;

    public static Connection connection() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Connected to database");
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
