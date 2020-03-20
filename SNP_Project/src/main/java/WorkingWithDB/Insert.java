package WorkingWithDB;

import com.sun.tools.javac.Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static boolean insert(String Main_Gene_name, String initialAA, String finalAA, String position,
                          String Type_of_Variant, String dbSNP, String Disease_name) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.connection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO snp_db VALUES (?, ?, ?, ?,?,?,?)");
            ps.setString(1, Main_Gene_name);
            ps.setString(2,initialAA);
            ps.setString(3,finalAA);
            ps.setString(4,position);
            ps.setString(5,Type_of_Variant);
            ps.setString(6,dbSNP);
            ps.setString(7,Disease_name);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            connection.close();
            return false;
        }
    }
// Test Test
    public static void main(String[] args) throws SQLException {
        Insert.insert("aaaaa","arg","his"
                ,"50","mutation", "ssr44","Covid-19");
    }
}