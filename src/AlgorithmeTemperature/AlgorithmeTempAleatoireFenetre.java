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
public class AlgorithmeTempAleatoireFenetre extends AlgorithmeTemperature{
    
    private static final double VALEUR_PAR_DEFAULT=15;
    private static final double FENETRE_PAR_DEFAULT=3;
    
    private double valeur;
    private double fenetre;
    
    /**
     * crée un AlgorithmeTempAleatoireFenetre
     */
    public AlgorithmeTempAleatoireFenetre() {
        valeur=VALEUR_PAR_DEFAULT;
        fenetre=FENETRE_PAR_DEFAULT;
    }
    
    /**
     * change la valeur
     * 
     * @param valeur 
     * nouvelle valeur
     */
    public void setValeur(double valeur){
        this.valeur=valeur;
    }
    
    /**
     * change la fenetre
     * 
     * @param fenetre 
     * nouvelle fenetre
     */
    public void setFenetre(double fenetre){
        this.fenetre=fenetre>0?fenetre:this.fenetre;
    }   
    
    /**
     * génère une temperature aléatoire dans une fenêtre
     * 
     * @return la température générée
     */
    @Override
    public double genererTemperature() {
        valeur+=random()*fenetre*2-fenetre;
        return valeur;
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return "température aléatoire fenêtré";
    }
    
    /**
     * modifie les paramètres de l'algorithme
     * 
     * @param arguments 
     * le premier argument change la fenêtre
     * le second éventuel argument change la valeur de départ
     */
    @Override
    public void setParametres(double... arguments) {
        setFenetre(arguments[0]);
        if(arguments.length>1){
            setValeur(arguments[1]);
        }
    }
}
