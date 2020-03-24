package WorkingWithDB;

import WorkingWithDB.Queries;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import static WorkingWithDB.Insert.insert;
import static WorkingWithDB.QueryExecution.execQuery;
//import static db.QueryExecution.execQuery;

public class switchc {
    Scanner in =new Scanner(System.in);
    public static void run(String month) throws SQLException {
        Scanner in = new Scanner(System.in);
        Queries q = new Queries();
        ResultSetMetaData thisdummyvar=null;
        ResultSet resultSet;
        int number_of_the_fricken_columns;
        String keep;
        String input1;
        String input2;
        String input3;
        int input4;
        String input5;
        String input6;
        String input7;

        switch (month.toLowerCase()) {
            case "1":

                resultSet = (ResultSet) execQuery(q.countPlymorphism());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                //
                break;
            case "2":

                resultSet = (ResultSet) execQuery(q.countDisease());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                //
                break;
            case "3":
                resultSet = (ResultSet) execQuery(q.countUnclassified());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                //
                break;
            case "4":
                resultSet = (ResultSet)    execQuery(q.classification());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                break;
            case "5":
                System.out.println("Enter Main_Gene_name");
                input1=in.nextLine();
                System.out.println("Enter initialAA");
                input2=in.nextLine();
                System.out.println("Enter finalAA");
                input3=in.nextLine();
                System.out.println("Enter position");
                input4= Integer.parseInt(in.nextLine());
                System.out.println("EnterType_of_Variant");
                input5=in.nextLine();
                System.out.println("Enter dbSNP");
                input6=in.nextLine();
                System.out.println("EnterDisease_name");
                input7=in.nextLine();
                insert(input1,input2,input3,input4,input5,input6,input7);
                System.out.println("Insertion Completed");
                break;
            case "6":
                System.out.println("Enter create queries");
                keep = in.nextLine();
                Create.createdb(keep);
                break;
            case "7":
                resultSet = (ResultSet) execQuery(q.subinterval_counts());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                //
                break;
            case "8":
                resultSet = (ResultSet) execQuery(q.miningResult());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                //
                break;
            case "9":
                resultSet = (ResultSet) execQuery(q.rules_v_types());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                //
                break;
            case "10":
                System.out.println("Enter your query");
                keep=in.nextLine();
                resultSet = (ResultSet)     execQuery(keep);
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                break;
            default:
                System.out.println("please try again.");
                System.out.println();
                break;
        }


    }

    private static void Print(ResultSetMetaData thisdummyvar, ResultSet resultSet, int number_of_the_fricken_columns) throws SQLException {
        while (resultSet.next()) {
            for (int count = 1; count <= number_of_the_fricken_columns; count++) {
                String s = thisdummyvar.getColumnName(count);
                System.out.print(s + ": " + resultSet.getString(count) + " ");
            }
            System.out.println(" ");
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
                        "6: Create Table\n"+
                        "7: Count_Subinterval\n" +
                        "8: Display Mining Result\n"+
                        "9: Display Rule_ vs_Type_Of_variants\n"+
                        "10: others"

        );
        System.out.println("Enter number of function to run");
        month = inp.nextLine();
        run(month);

    }
}