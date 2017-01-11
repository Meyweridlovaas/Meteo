/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Interfaces.IDoubleObservable;
import Interfaces.IDoubleObservateur;
import meteo.Capteur;

/**
 *
 * @author vagonon1
 */
public abstract class Fenetre implements IDoubleObservateur{
    
    private Capteur observe;
    
    @Override
    public void ajouterObserve(IDoubleObservable obs) {
        if(obs.getClass()==Capteur.class)
            observe=(Capteur)obs;
    }
    
    @Override
    public void supprimerObserve(IDoubleObservable obs) {
        observe=null;
    }
}
