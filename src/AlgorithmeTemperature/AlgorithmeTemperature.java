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
public abstract class AlgorithmeTemperature {
    
    /**
     * génère une temperature
     * 
     * @return la température générée
     */
    public abstract double genererTemperature();
    
    /**
     * modifie les paramètres de l'algorithme
     * différent pour chaque algorithme car leur paramètres sont différents
     * 
     * @param arguments 
     * les arguments qui permettront de modifier les paramètres
     */    
    public abstract void setParametres(double... arguments);
}
