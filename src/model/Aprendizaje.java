package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public abstract class Aprendizaje {

    // key = class
    // value = muestras de formadas por d dimensiones
    protected HashMap<String, ArrayList<Object>> datos;
    protected int dimension;

    public Aprendizaje(int dimension) {
        this.datos = new HashMap<>();
        this.dimension = dimension;
    }

    public void aprender(String archivo) {
        StringTokenizer str = new StringTokenizer(tools.Reader.leerFichero(archivo), "\n");

        String linea;
        String arrayMuestra[];
        while (str.hasMoreTokens()) {

            linea = str.nextToken();
            arrayMuestra = linea.split(",");

            if (!this.datos.containsKey(arrayMuestra[arrayMuestra.length - 1])) {
                //System.out.println(arrayMuestra[arrayMuestra.length - 1]);
                this.datos.put(arrayMuestra[arrayMuestra.length - 1], new ArrayList<>());
            }

            double[] muestra = new double[arrayMuestra.length - 1];

            for (int i = 0; i < arrayMuestra.length - 1; i++) {
                muestra[i] = Double.valueOf(arrayMuestra[i]);
                //System.out.println(muestra[i]);
            }

            this.datos.get(arrayMuestra[arrayMuestra.length - 1]).add(muestra);
        }

    }

    public String printMuestras(String clase) {
        String res = "";
        res += "Resultados para " + clase + ":\n";
        for (int i = 0; i < this.datos.get(clase).size(); i++) {

            double[] muestra = (double[]) this.datos.get(clase).get(i);
            res += "\nMuestra " + i + ": ";
            for (double d : muestra) {
                res += d + " ";
            }
        }
        return res;
    }

    /**
     * Dada una muestra devuelve que grado de pertenencia tiene a la clase dada.
     *
     * @param muestra muestra para comparar
     * @param clase clase de la que queremos saber el grado de pertenencia de la
     * muestra
     * @return grado de pertenencia de la muestra a la clase
     */
    public abstract double gradoDePertenencia(double[] muestra, String clase);
}
