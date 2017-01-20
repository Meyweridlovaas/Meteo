/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author vagonon1
 */
public interface IDoubleObservable {
    
    /**
     * ajoute un observateur
     * 
     * @param obs 
     * observateur à ajouter
     */
    public void ajouterObservateur(IDoubleObservateur obs);
    
    /**
     * supprime un observateur
     * 
     * @param obs 
     * observateur à supprimer
     */
    public void supprimerObservateur(IDoubleObservateur obs);
    
    /**
     * supprime tous les observateurs
     */
    public void supprimerTousLesObservateurs();
}
