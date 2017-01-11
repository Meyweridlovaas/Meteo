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
    public void ajouterObservateur(IDoubleObservateur obs);
    
    public void supprimerObservateur(IDoubleObservateur obs);
    
    public void supprimerTousLesObservateurs();
}
