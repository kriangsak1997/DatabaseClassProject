package WorkingWithDB;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;

public class QueryExecution {
    private  static ConnectionFactory connectionFactory =  new ConnectionFactory();
    private static Connection connection;
    private static Statement statement;
    private static ResultSet st;
    public static Object execQuery(String inputQuery) throws SQLException {
    connection = connectionFactory.connection();
        try {
             statement = connection.createStatement();
             st = statement.executeQuery(inputQuery);
    } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            connection.close();
        }
        return st;
    }

    public static void main(String[] args) throws SQLException {
        ResultSet set = (ResultSet) QueryExecution.execQuery("select type_of_variant, count(main_gene_name) from snp_db where initialaa='Tyr' and finalaa = 'Cys' group by type_of_variant;");
        if (set != null) {
            ResultSetMetaData thisdummyvar = set.getMetaData();
            int number_of_the_fricken_columns = thisdummyvar.getColumnCount();
            while (set.next()) {
                for (int count = 1; count <= number_of_the_fricken_columns; count++) {
                    String s = thisdummyvar.getColumnName(count);
                    System.out.print(s + ": " + set.getString(count) + " ");
                }
                System.out.println(" ");
            }
        }
        System.out.println("Null result detected");
    }

}
