package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Writer {

    public static boolean escribirFichero(String file, String txt) {

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String textbefore = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                textbefore += linea + System.getProperty("line.separator");;
            }

            br.close();
            fr.close();
            
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            
            
            pw.write(textbefore + txt);
            
            pw.close();
            bw.close();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return false;

    }

    public static boolean sobreescribirFichero(String file, String txt) {

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            
            
            pw.write(txt);
            
            pw.close();
            bw.close();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return false;

    }
}
