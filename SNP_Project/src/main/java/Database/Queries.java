package Database;

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




}
