package WorkingWithDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    static ConnectionFactory connectionFactory ;
    static Connection connection ;
    public static boolean createdb(String queries) throws SQLException {
        connectionFactory = new ConnectionFactory();
        connection = connectionFactory.connection();

        try {
            //drop the table first if exists.

//            dropper(name);
            PreparedStatement ps = connection.prepareStatement(" ?;" );
            ps.setString(1, queries);
            System.out.println(ps.executeUpdate());
            int i = ps.executeUpdate();

            if (i == 1) {
                System.out.println("Table creaated");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
            return false;
        }
    }


}
