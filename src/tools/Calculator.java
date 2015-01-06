package tools;

public class Calculator {

    // con matrices de double
    public static double[][] sumarMatrices(double[][] x, double y[][]) {

        // Caso de error
        if ((x.length != y.length) || (x[0].length != y[0].length)) {
            System.err.println("Para sumar matrices, ambas tienen que tener la misma dimension");
            return null;
        }

        double[][] res = new double[x.length][x[0].length];

        for (int r = 0; r < x.length; r++) {
            for (int c = 0; c < x[r].length; c++) {
                res[r][c] = x[r][c] + y[r][c];
            }
        }

        return res;
    }

    public static double[][] restarMatrices(double[][] x, double y[][]) {

        // Caso de error
        if ((x.length != y.length) || (x[0].length != y[0].length)) {
            System.err.println("Para restar matrices, ambas tienen que tener la misma dimension");
            return null;
        }

        double[][] res = new double[x.length][x[0].length];

        for (int r = 0; r < x.length; r++) {
            for (int c = 0; c < x[r].length; c++) {
                res[r][c] = x[r][c] - y[r][c];
            }
        }

        return res;
    }

    public static double[][] multiplicarMatrices(double[][] x, double y[][]) {

        // Caso de error
        if ((x[0].length != y.length)) {
            System.err.println("Para multiplicar matrices, la primera matriz tiene qu etener el mismo numero de columnas que la segunda filas");
            return null;
        }

        double[][] res = new double[x.length][x[0].length];

        for (int rx = 0; rx < x.length; rx++) {
            for (int cy = 0; cy < y[0].length; cy++) {
                res[rx][cy] = 0;
                for (int cxry = 0; cxry < y.length; cxry++) {
                    res[rx][cy] += x[rx][cxry] * y[cxry][cy];
                }
            }
        }

        return res;
    }

    public static double[][] dividirMatrices(double[][] x, double y[][]) {

        // Caso de error
        if ((x[0].length != y.length)) {
            System.err.println("Para dividir matrices, la primera matriz tiene qu etener el mismo numero de columnas que la segunda filas");
            return null;
        }

        double[][] res = new double[x.length][x[0].length];

        for (int rx = 0; rx < x.length; rx++) {
            for (int cy = 0; cy < y[0].length; cy++) {
                res[rx][cy] = 0;
                for (int cxry = 0; cxry < y.length; cxry++) {
                    res[rx][cy] += x[rx][cxry] / y[cxry][cy];
                }
            }
        }

        return res;
    }

    public static double[][] multiplicarMatrizValor(double[][] m, double v) {
        double[][] res = new double[m.length][m[0].length];

        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                res[r][c] = v * m[r][c];
            }
        }

        return res;
    }

    public static double[][] dividirMatrizValor(double[][] m, double v) {
        double[][] res = new double[m.length][m[0].length];

        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                res[r][c] = m[r][c] / v;
            }
        }

        return res;
    }

    public static double[][] transponerMatriz(double[][] m) {
        double[][] res = new double[m.length][m[0].length];
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[0].length; c++) {
                res[r][c] = m[c][r];
            }
        }
        return res;
    }

    public static double determinanteMatriz(double[][] m) {

        // Caso de error
        if (m.length != m[0].length) {
            System.err.println("Para calcular el determinante de una matriz, la matriz tiene que se cuadrada");
            return Double.NaN;
        }
        
        // Caso base
        if (m.length == 2) {
            return (m[0][0] * m[1][1]) - (m[1][0] * m[0][1]);
        }

        double suma = 0;
        for (int i = 0; i < m.length; i++) {
            double[][] nm = new double[m.length - 1][m.length - 1];
            for (int j = 0; j < m.length; j++) {
                if (j != i) {
                    for (int k = 1; k < m.length; k++) {
                        int indice = -1;
                        if (j < i) {
                            indice = j;
                        } else if (j > i) {
                            indice = j - 1;
                        }
                        nm[indice][k - 1] = m[j][k];
                    }
                }
            }
            if (i % 2 == 0) {
                suma += m[i][0] * determinanteMatriz(nm);
            } else {
                suma -= m[i][0] * determinanteMatriz(nm);
            }
        }
        return suma;

    }

    /**
     * Devuelve la matriz inversa de otra matriz
     * @author http://www.sanfoundry.com/java-program-find-inverse-matrix/
     * @param m mattriz a invertir
     * @return la matriz inversa a m o null si no se puede invertir
     */
    public static double[][] invertirMatriz(double m[][]) {

        if(Calculator.determinanteMatriz(m) == 0.0){
            System.err.println("No se puede hayar la matriz inversa d euna matriz cuyo determinante es 0");
            return null;
        }
        
        int n = m.length;

        double x[][] = new double[n][n];

        double b[][] = new double[n][n];

        int index[] = new int[n];

        for (int i = 0; i < n; ++i) {
            b[i][i] = 1;
        }

        // Transform the matrix into an upper triangle
        gaussian(m, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    b[index[j]][k] -= m[index[j]][i] * b[index[i]][k];
                }
            }
        }

        // Perform backward substitutions
        for (int i = 0; i < n; ++i) {

            x[n - 1][i] = b[index[n - 1]][i] / m[index[n - 1]][n - 1];

            for (int j = n - 2; j >= 0; --j) {

                x[j][i] = b[index[j]][i];

                for (int k = j + 1; k < n; ++k) {

                    x[j][i] -= m[index[j]][k] * x[k][i];

                }

                x[j][i] /= m[index[j]][j];

            }

        }

        return x;

    }

    /**
     * metodo que utiliza el metodo invertirMatriz
     * @author http://www.sanfoundry.com/java-program-find-inverse-matrix/
     * @param m
     * @param index 
     */
    private static void gaussian(double m[][], int index[]) {

        int n = index.length;

        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {

            double c1 = 0;

            for (int j = 0; j < n; ++j) {

                double c0 = Math.abs(m[i][j]);

                if (c0 > c1) {
                    c1 = c0;
                }

            }

            c[i] = c1;

        }

        // Search the pivoting element from each column
        int k = 0;

        for (int j = 0; j < n - 1; ++j) {

            double pi1 = 0;

            for (int i = j; i < n; ++i) {

                double pi0 = Math.abs(m[index[i]][j]);

                pi0 /= c[index[i]];

                if (pi0 > pi1) {

                    pi1 = pi0;

                    k = i;

                }

            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];

            index[j] = index[k];

            index[k] = itmp;

            for (int i = j + 1; i < n; ++i) {

                double pj = m[index[i]][j] / m[index[j]][j];

                // Record pivoting ratios below the diagonal
                m[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l) {
                    m[index[i]][l] -= pj * m[index[j]][l];
                }

            }

        }

    }

    public static String printMatrix(double[][] m) {
        String res = "";

        for (double[] r : m) {
            res += "|";
            for (double v : r) {
                res += " " + v + " ";
            }
            res += "|";
            res += System.getProperty("line.separator");
        }

        return res;
    }

    

}
