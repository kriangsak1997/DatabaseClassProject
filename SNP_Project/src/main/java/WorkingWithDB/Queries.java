package WorkingWithDB;

import com.sun.tools.javac.Main;

public class Queries {
     public static String countPlymorphism(){
         return "select * \n" +
                 "from snp_db where type_of_variant ='Polymorphism' limit 15\n";
     }
    public static String countDisease(){
        return "select * \n" +
                "from snp_db where type_of_variant ='Disease' limit 15\n";
    }
    public static String countUnclassified(){
        return "select * \n" +
                "from snp_db where type_of_variant ='Unclassified' limit 15\n";
    }

    public static String classification() {
        return "select type_of_variant, count(initialaa) as total_counts \n" +
                "from snp_db group by type_of_variant order by count(initialaa)\n";
    }

    public static String insertInto(String Main_Gene_name, String initialAA, String finalAA, String position,
                                    String Type_of_Variant, String dbSNP, String Disease_name){
         return "insert into snp_db(main_gene_name, initialAA, finalAA, position_of_change, type_of_variant, dbSNP, disease_name) \n"+
                 "values ('" + Main_Gene_name +"','" + initialAA +"','" + finalAA + "','" + position +"','" + Type_of_Variant +"','"
                 + dbSNP+"','" + Disease_name+"');";
    }
}
