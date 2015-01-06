package tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {

    public static String leerFichero(String file) {
        String txt = "";

        try {
            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                txt += linea + System.getProperty("line.separator");;
            }
            
            br.close();

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return txt;

    }

}
