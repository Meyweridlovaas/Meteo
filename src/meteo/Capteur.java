/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

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
    
    protected Capteur(){
        observateurs=new ArrayList<>();
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    protected void setTemperature(double temperature){
        this.temperature=temperature;
        observateurs.forEach((obs) -> {
            Platform.runLater(()->obs.update());
        });
    }
    
    @Override
    public void ajouterObservateur(IDoubleObservateur obs){
        observateurs.add(obs);
        obs.ajouterObserve(this);
        Platform.runLater(()->obs.update());
    }

    @Override
    public void supprimerObservateur(IDoubleObservateur obs) {
        observateurs.remove(obs);
        obs.supprimerObserve(this);
    }

    @Override
    public void supprimerTousLesObservateurs() { // pas à jour
        observateurs.clear();
    }
}
