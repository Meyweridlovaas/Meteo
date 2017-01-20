/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capteurs;

import AlgorithmeTemperature.AlgorithmeTemperature;
import AlgorithmeTemperature.AlgorithmeTempConstant;

/**
 *
 * @author vagonon1
 */
public class CapteurAvecAlgorithme extends Capteur {
    
    private static final double INTERVALLE_PAR_DEFAULT=2;

    private AlgorithmeTemperature algorithme;
    private double intervalleMiseAJour;
    private ThreadCapteur thread;
    
    /**
     * crée un capteur avec algorithme
     */
    public CapteurAvecAlgorithme() {
        this(INTERVALLE_PAR_DEFAULT);
    }    
    
    /**
     * crée un capteur avec algorithme
     * 
     * @param intervalle 
     * intervalle de mise à jour de la température
     */
    public CapteurAvecAlgorithme(double intervalle) {
        intervalleMiseAJour=intervalle;
        algorithme=new AlgorithmeTempConstant();
        setTemperature();         
        thread=new ThreadCapteur(this, intervalleMiseAJour);
    }
    
    /**
     * @return the algorithme
     */
    public AlgorithmeTemperature getAlgorithme() {
        return algorithme;
    }
    
    /**
     * modifie l'algorithme
     * 
     * @param algo 
     * nouvel algorithme
     */
    public void setAlgorithme(AlgorithmeTemperature algo){
        algorithme=algo;
    }
    
    /**
     * @return the intervalleMiseAJour
     */
    public double getIntervalleMAJ(){
        return intervalleMiseAJour;
    }
    
    /**
     * modifie l'intervalle de mise à jour
     * 
     * @param intervalle 
     * nouvel intervalle
     */
    public void setIntervalleMAJ(double intervalle){
        intervalleMiseAJour=intervalle>0?intervalle:intervalleMiseAJour;
    }     
    
    /**
     * modifie la température
     */
    public void setTemperature(){
        setTemperature(getAlgorithme().genererTemperature());
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return "Capteur avec algorithme "+getAlgorithme();
    }    
    
}
