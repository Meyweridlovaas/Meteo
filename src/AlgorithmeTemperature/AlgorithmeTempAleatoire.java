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
public class AlgorithmeTempAleatoire extends AlgorithmeTemperature{

    /**
     * génère une temperature aléatoire
     * 
     * @return la température générée
     */
    @Override
    public double genererTemperature() {        
        return random()*Double.MAX_VALUE*2;
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return "température aléatoire";
    }
    
    /**
     * modifie les paramètres de l'algorithme
     * ne fait rien car aucun paramètres
     * 
     * @param arguments 
     * ne fait rien
     */
    @Override
    public void setParametres(double... arguments) {
        return;
    }
    
}
