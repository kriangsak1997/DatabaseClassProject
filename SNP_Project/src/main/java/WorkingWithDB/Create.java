package WorkingWithDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    static ConnectionFactory connectionFactory ;
    static Connection connection ;
    static Statement statement;
    public static boolean createdb(String queries) throws SQLException {
        connectionFactory = new ConnectionFactory();
        connection = connectionFactory.connection();
        Boolean isCreated = false;

        try {
            statement = connection.createStatement();
            statement.executeQuery(queries);

            isCreated=true;
            System.out.println("Table creaated");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
            return isCreated;
        }
    }


}
