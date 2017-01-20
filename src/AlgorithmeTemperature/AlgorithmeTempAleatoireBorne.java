/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmeTemperature;

import static java.lang.Math.random;

/**
 *
 * @author vagonon1
 */
public class AlgorithmeTempAleatoireBorne extends AlgorithmeTemperature{
    
    private static final double MIN_PAR_DEFAULT=15;
    private static final double MAX_PAR_DEFAULT=25;
    
    private double min;
    private double max;
    
    /**
     * crée un AlgorithmeTempAleatoireBorne
     */
    public AlgorithmeTempAleatoireBorne() {
        min=MIN_PAR_DEFAULT;
        max=MAX_PAR_DEFAULT;
    }
    
    /**
     * modifie le minimum
     * 
     * @param min 
     * nouveau minimum
     */
    public void setMin(double min){
        this.min=min<max?min:this.min;
    }
    
    /**
     * modifie le maximum
     * 
     * @param max 
     * nouveau maximum 
     */
    public void setMax(double max){
        this.max=max>min?max:this.max;
    }
    
    /**
     * génère une temperature aléatoirement comprise entre min et max
     * 
     * @return la température générée
     */
    @Override
    public double genererTemperature() {
        double ecart=max-min;        
        return ecart*random()+min;
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return "température aléatoire borné";
    }
    
    /**
     * modifie les paramètres de l'algorithme
     * 
     * @param arguments 
     * le premier argument change le minimum
     * le second éventuel argument change le maximum
     */
    @Override
    public void setParametres(double... arguments) {
        setMin(arguments[0]);
        if(arguments.length>1){
            setMax(arguments[1]);
            if(min!=arguments[0]){
                setMin(arguments[0]);
            }
        }
    }
}
