package model;

import java.util.HashMap;

public class Bayes {

    // dimesion de las muestras
    private int d;
    // key = class
    // value = muestras de formadas por d dimensiones
    private HashMap<String,Double[][]> datos;
    
    public Bayes(int dimension){
        this.d = dimension;
    }
    
    
    public void aprender (String archivo){
        
    }
    
}