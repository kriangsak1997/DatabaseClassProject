package WorkingWithDB;
import java.net.URI;

public class Browse {
        static String code;
        public static void brows(String inoutcode){
            code = inoutcode;
//https://www.ncbi.nlm.nih.gov/snp/rs62645950
            try {
                URI uri= new URI("https://www.ncbi.nlm.nih.gov/snp/" + code);
                java.awt.Desktop.getDesktop().browse(uri);
                System.out.println("Web page opened in browser");

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
}
