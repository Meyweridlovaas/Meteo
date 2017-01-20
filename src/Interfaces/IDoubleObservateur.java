package Interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vagonon1
 */
public interface IDoubleObservateur {
    
    /**
     * méthode permettant à l'objet de se mettre à jour
     */
    void update();
    
    /**
     * ajoute un objet observé
     * 
     * @param obs 
     * objet observé
     */
    void ajouterObserve(IDoubleObservable obs);
    
    /**
     * supprime un objet observé
     * 
     * @param obs 
     * objet supprimé
     */
    void supprimerObserve(IDoubleObservable obs);
}
