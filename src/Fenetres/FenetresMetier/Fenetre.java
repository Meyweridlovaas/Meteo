/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres.FenetresMetier;

import Interfaces.IDoubleObservable;
import Interfaces.IDoubleObservateur;
import javafx.stage.Stage;
import Capteurs.Capteur;

/**
 *
 * @author vagonon1
 */
public abstract class Fenetre extends Stage implements IDoubleObservateur{
    
    private Capteur observe;
    
    /**
     * ajoute un objet observé
     * 
     * @param obs 
     * objet observé
     */
    @Override
    public void ajouterObserve(IDoubleObservable obs) {        
        if(Capteur.class.isInstance(obs))
            observe=(Capteur)obs;
    }
    
    /**
     * supprime un objet observé
     * 
     * @param obs 
     * objet supprimé
     */
    @Override
    public void supprimerObserve(IDoubleObservable obs) {
        observe=null;
    }

    /**
     * @return the observe
     */
    public Capteur getObserve() {
        return observe;
    }
}
