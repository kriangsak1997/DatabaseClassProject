package Queries;


import Database.Queries;

public class InsertInto {
    String insertInto(String Main_Gene_name, String initialAA, String finalAA, String position,
                                    String Type_of_Variant, String dbSNP, String Disease_name){
        return "insert into snp_db(main_gene_name, initialAA, finalAA, position_of_change, type_of_variant, dbSNP, disease_name) \n"+
                "values ('" + Main_Gene_name +"','" + initialAA +"','" + finalAA + "','" + position +"','" + Type_of_Variant +"','"
                + dbSNP+"','" + Disease_name+"');";
    }

}
