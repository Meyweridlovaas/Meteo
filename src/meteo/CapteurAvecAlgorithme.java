/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import AlgorithmeTemperature.AlgorithmeTemperature;
import AlgorithmeTemperature.AlgorithmeTempConstant;
import javafx.application.Platform;

/**
 *
 * @author vagonon1
 */
public class CapteurAvecAlgorithme extends Capteur {
    
    private static final double INTERVALLE_PAR_DEFAULT=2;

    private AlgorithmeTemperature algorithme;
    private double intervalleMiseAJour;
    private ThreadCapteur thread;

    public CapteurAvecAlgorithme() {
        this(INTERVALLE_PAR_DEFAULT);
    }    

    public CapteurAvecAlgorithme(double intervalle) {
        intervalleMiseAJour=intervalle;
        algorithme=new AlgorithmeTempConstant();
        setTemperature(); //non définitif         
        thread=new ThreadCapteur(this, intervalleMiseAJour);
    }
    
    public void setAlgorithme(AlgorithmeTemperature algo){
        algorithme=algo;
    }
    
    public double getIntervalleMAJ(){
        return intervalleMiseAJour;
    }
    
    public void setIntervalleMAJ(double intervalle){
        intervalleMiseAJour=intervalle>0?intervalle:intervalleMiseAJour;
    }     
    
    public void setTemperature(){
        setTemperature(algorithme.genererTemperature());
    }
    
    @Override
    public String toString(){
        return "Capteur avec algorithme";
    }
    
}
