package db;

import java.util.Scanner;

public class switchc {

    public static void run(String month) {
        Scanner in = new Scanner(System.in);
        Queries q = new Queries();
        String input1;
        String input2;
        String input3;
        String input4;
        String input5;
        String input6;
        String input7;

        switch (month.toLowerCase()) {
            case "1":
                q.countPlymorphism();
                break;
            case "2":
                q.countDisease();
                break;
            case "3":
                q.countUnclassified();
                break;
            case "4":
                q.classification();
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
                q.insertInto(input1,input2,input3,input4,input5,input6,input7);
                break;
            default:
                System.out.println("please try again.");
                System.out.println();
                break;
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String month;
        System.out.println(
                "1: count plymorphism\n" +
                "2: count disease\n" +
                "3: count unclassified\n" +
                "4: classification\n" +
                "5: insert");
        System.out.println("Enter number of function to run");
        month = in.nextLine();
        run(month);
//        if (month !=1 ||month !=2||month !=3||month !=4||month !=5){
//            System.out.println("invalid choice");
//            System.out.println("choose again");
//
//        }

    }
}