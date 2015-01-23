package model;

import Jama.Matrix;
import java.util.ArrayList;

public class Bayes extends Aprendizaje {

    public Bayes(int dimension) {
        super(dimension);
    }

    @Override
    public double gradoDePertenencia(double[] muestra, String clase) {

        // Convertimos la muestra en matriz
        Matrix x = new Matrix(muestra, 1);

        // Calculamos el punto medio de las muestras recogidas de la clase
        Matrix m = this.calcularMatrizDeMedia(super.datos.get(clase));
        // Calculamos la matriz de covarianza
        Matrix c = this.calcularMatrizDeCovarianza(m, super.datos.get(clase));

        double distance = (x.minus(m).times(c.inverse()).times(x.minus(m).transpose()).get(0, 0));
        
        //double solution = (Math.exp((-0.5) * distance)) / ((Math.pow(2 * Math.PI, super.dimension / 2.0)) * Math.pow(c.det(), 0.5));
                
        return distance;
    }

    private Matrix calcularMatrizDeCovarianza(Matrix m, ArrayList<Object> muestras_clase) {

        Matrix xi;
        Matrix co = new Matrix(super.dimension, super.dimension);

        for (Object muestra : muestras_clase) {
            xi = new Matrix((double[]) muestra, 1);
            co.plusEquals(xi.minus(m).transpose().times(xi.minus(m)));
        }

        return co.times(1.0 / muestras_clase.size());
    }

    private Matrix calcularMatrizDeMedia(ArrayList<Object> muestras_clase) {

        Matrix m = new Matrix(1, super.dimension);
        Matrix xi;

        for (Object muestra : muestras_clase) {

            xi = new Matrix((double[]) muestra, 1);
            m.plusEquals(xi);

        }

        return m.times(1.0 / muestras_clase.size());
    }

}
