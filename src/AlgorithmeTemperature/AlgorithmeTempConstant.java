/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmeTemperature;

/**
 *
 * @author vagonon1
 */
public class AlgorithmeTempConstant extends AlgorithmeTemperature{
    
    private static final double VALEUR_PAR_DEFAULT=13.37;
    
    private double valeur;
    
    /**
     * crée un AlgorithmeTempConstant
     */
    public AlgorithmeTempConstant() {
        valeur=VALEUR_PAR_DEFAULT;
    }
    
    /**
     * modifie la valeur
     * 
     * @param valeur 
     * nouvelle valeur
     */
    public void setValeur(double valeur){
        this.valeur=valeur;
    }    
    
    /**
     * génère une temperature constante
     * 
     * @return la température générée
     */
    @Override
    public double genererTemperature() {
        return valeur;
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return "température constant";
    }
    
    /**
     * modifie les paramètres de l'algorithme
     * 
     * @param arguments 
     * le premier argument change la température renvoyée
     */
    @Override
    public void setParametres(double... arguments) {
        setValeur(arguments[0]);
    }
    
}
