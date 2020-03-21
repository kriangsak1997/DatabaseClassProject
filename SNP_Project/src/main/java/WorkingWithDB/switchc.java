package WorkingWithDB;

<<<<<<< HEAD
import WorkingWithDB.Insert;
import WorkingWithDB.Queries;
import WorkingWithDB.QueryExecution;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
=======
>>>>>>> e062871c55d1a3515b57cf3661d18102f3086b1d
import java.sql.SQLException;
import java.util.Scanner;

import static db.QueryExecution.execQuery;

public class switchc {
    Scanner in =new Scanner(System.in);
    public static void run(String month) throws SQLException {
        Scanner in = new Scanner(System.in);
        QueryExecution executor = new QueryExecution();
        Queries q = new Queries();

        Insert inserter = new Insert();
=======
        String keep;
>>>>>>> 132a7df343dcc1b8b6bb09ce506c8d84cdebe5fa
        String input1;
        String input2;
        String input3;
        String input4;
        String input5;
        String input6;
        String input7;

        ResultSetMetaData thisdummyvar;

        switch (month.toLowerCase()) {
            case "1":
<<<<<<< HEAD
                ResultSet resultSet = (ResultSet) executor.execQuery(q.countPlymorphism());
                thisdummyvar =resultSet.getMetaData();
            int number_of_the_fricken_columns = thisdummyvar.getColumnCount();
            while (resultSet.next()) {
                for (int count = 1; count <= number_of_the_fricken_columns; count++) {
                    String s = thisdummyvar.getColumnName(count);
                    System.out.print(s + ": " + resultSet.getString(count)+" ");
                }
                System.out.println(" ");
                //
            }
                break;
            case "2":
                executor.execQuery(q.countDisease());
                break;
            case "3":
                executor.execQuery(q.countUnclassified());
                break;
            case "4":
                executor.execQuery(q.classification());
=======
                execQuery(q.countPlymorphism());
                break;
            case "2":
                execQuery(q.countDisease());
                break;
            case "3":
                execQuery(q.countUnclassified());
                break;
            case "4":
                execQuery(q.classification());
>>>>>>> e062871c55d1a3515b57cf3661d18102f3086b1d
                break;
            case "5":
                System.out.println("Enter Main_Gene_name");
                input1=in.nextLine();
                System.out.println("Enter initialAA");
                input2=in.nextLine();
                System.out.println("Enter finalAA");
                input3=in.nextLine();
                System.out.println("Enter position");
                input4=in.nextLine();
                System.out.println("EnterType_of_Variant");
                input5=in.nextLine();
                System.out.println("Enter dbSNP");
                input6=in.nextLine();
                System.out.println("EnterDisease_name");
                input7=in.nextLine();
<<<<<<< HEAD
                inserter.insert(input1,input2,input3,input4,input5,input6,input7);

=======
                execQuery(q.insertInto(input1,input2,input3,input4,input5,input6,input7));
>>>>>>> e062871c55d1a3515b57cf3661d18102f3086b1d
                break;
            case "6":
                System.out.println("Enter your query");
                keep=in.nextLine();
                execQuery(keep);
            default:
                System.out.println("please try again.");
                System.out.println();
                break;
        }

    }

    public static void main(String[] args) throws SQLException {
        Scanner inp=new Scanner (System.in);
        String month;
        System.out.println(
                "1: count plymorphism\n" +
                        "2: count disease\n" +
                        "3: count unclassified\n" +
                        "4: classification\n" +
                        "5: insert\n" +
                        "6: your own query"
        );
        System.out.println("Enter number of function to run");
        month = inp.nextLine();
        run(month);

    }
}