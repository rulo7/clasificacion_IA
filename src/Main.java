
import Jama.Matrix;

public class Main {

    public static void main(String[] args) {

        double[][] matrix = {{2, 0, 1}, {1, 1, -4}, {3, 7, -3}};
        Matrix m = new Matrix(matrix);

        m.inverse().print(1, 2);
        /*
         double[][] x = {{1, 2}, {3, 4}};
         double[][] y = {{4, 3}, {1, 2}};

         System.out.println("Muestra");

         System.out.println(Calculator.printMatrix(x));
         System.out.println(Calculator.printMatrix(y));

         System.out.println("Suma");

         System.out.println(Calculator.printMatrix(Calculator.sumarMatrices(x, y)));

         System.out.println("Resta");

         System.out.println(Calculator.printMatrix(Calculator.restarMatrices(x, y)));

         System.out.println("Multiplicar");

         System.out.println(Calculator.printMatrix(Calculator.multiplicarMatrices(x, y)));

         System.out.println("Transponer");

         System.out.println(Calculator.printMatrix(Calculator.transponerMatriz(x)));
         System.out.println(Calculator.printMatrix(Calculator.transponerMatriz(y)));

         System.out.println("Determinante");

         System.out.println("x = " + Calculator.determinanteMatriz(x));
         System.out.println("y = " + Calculator.determinanteMatriz(y));

         System.out.println("Inversa");

         double[][] i = {{5, 3}, {1, 2}};
         System.out.println(Calculator.printMatrix(i));
         System.out.println(Calculator.printMatrix(Calculator.invertirMatriz(i)));
        

         System.out.println("Antes:");
         System.out.println(Reader.leerFichero("prueba.txt"));

         Writer.sobreescribirFichero("prueba.txt", "texto no añadido");
         System.out.println("Despues:");
         System.out.println(Reader.leerFichero("prueba.txt"));
         */
    }
}
