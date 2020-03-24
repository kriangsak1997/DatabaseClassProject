package WorkingWithDB;

import WorkingWithDB.Queries;
import com.mysql.cj.protocol.Resultset;

import javax.imageio.stream.ImageOutputStream;
import javax.swing.plaf.IconUIResource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import static WorkingWithDB.Insert.insert;
import static WorkingWithDB.QueryExecution.execQuery;
//import static db.QueryExecution.execQuery;

public class switchc {
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
            case"11":
                resultSet = (ResultSet) execQuery(q.countfinalalAA());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                //
                break;
            case"12":
                resultSet = (ResultSet) execQuery(q.countinitialAA());
                thisdummyvar =resultSet.getMetaData();
                number_of_the_fricken_columns = thisdummyvar.getColumnCount();
                Print(thisdummyvar, resultSet, number_of_the_fricken_columns);
                //
                break;
            case "13":
                Browse browse = new Browse();
                System.out.println("Enter dbSNP");
                keep=in.nextLine();
                browse.brows(keep);
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
        System.out.println("Welcome to our SNP database system class project\n" +
                "Here we will introduce you quickly to our schema for the main database\n" +
                "**SNP_DB**(Main_Gene_name  varchar, initialAA varchar,finalAA varchar,position_of_Change varchar,Type_of_Variant varchar,dbSNP varchar,Disease_name varchar)\n" +
                "\n" +
                "That is, \n" +
                "   *Main_Gene_name*  contains the name of the gene for each record, taking *strings* of gene names <\n" +
                " \n" +
                "  *initialAA* contains the amino acid (AA) abbreviation before a change occurs , taking *strings* of AA \n" +
                " \n" +
                " *finalAA* contains the amino acid (AA) abbreviation after a change occurs , taking *strings* of AA \n" +
                " \n" +
                " *position_of_Change* contains the position of AA (in the change of AA chains of a gene), taking **string** of position, which later will be altered to integer type \n" +
                " \n" +
                " *Type_of_Variant* contains the type of variants for which an SNP causes, taking *strings* of variant types \n" +
                " \n" +
                "  *dbSNP* take takes in database code used to access more information regarding a change in NCBI SNP database, taking strings of DB-code \n" +
                " \n" +
                "*Disease_name* contains the name of diseases, if applicable, caused by SNPs, taking *strings* of disease names.\n" +
                "  "
                +
                "\n" +
                "to enter our interactive switch case please select the following option\n"+
                "1: count poymorphism\n" +
                        "2: count disease\n" +
                        "3: count unclassified\n" +
                        "4: classification\n" +
                        "5: insert\n" +
                        "6: Create Table\n"+
                        "7: Count_Subinterval\n" +
                        "8: Display Mining Result\n"+
                        "9: Display Rule_ vs_Type_Of_variants\n"+
                        "10: others\n" +
                        "11: final amino acids group by counts\n" +
                        "12: initial amino acids group by counts\n" +
                        "13: brow more information of a record of interest"



        );
        System.out.println("Enter number of function to run");
        month = inp.nextLine();
        run(month);
    }
}