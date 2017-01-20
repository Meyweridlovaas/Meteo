/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capteurs;

import Interfaces.IDoubleObservateur;
import Interfaces.IDoubleObservable;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;

/**
 *
 * @author vagonon1
 */
public abstract class Capteur implements IDoubleObservable{
    
    private double temperature;
    protected List<IDoubleObservateur> observateurs;
    
    /**
     * crée la liste d'observateurs utilisée par les classes filles
     */
    protected Capteur(){
        observateurs=new ArrayList<>();
    }
    
    /**
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }
    
    /**
     * modifie la température
     * 
     * @param temperature 
     * nouvelle température
     */
    protected void setTemperature(double temperature){
        this.temperature=temperature;
        observateurs.forEach((obs) -> {
            Platform.runLater(()->obs.update());
        });
    }
    
    /**
     * ajoute un observateur
     * 
     * @param obs 
     * observateur à ajouter
     */
    @Override
    public void ajouterObservateur(IDoubleObservateur obs){
        observateurs.add(obs);
        obs.ajouterObserve(this);
        Platform.runLater(()->obs.update());
    }
    
    /**
     * supprime un observateur
     * 
     * @param obs 
     * observateur à supprimer
     */
    @Override
    public void supprimerObservateur(IDoubleObservateur obs) {
        observateurs.remove(obs);
        obs.supprimerObserve(this);
    }
    
    /**
     * supprime tous les observateurs
     */
    @Override
    public void supprimerTousLesObservateurs() { // pas à jour
        observateurs.clear();
    }
}
