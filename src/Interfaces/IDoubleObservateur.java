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
    void update();
    
    void ajouterObserve(IDoubleObservable obs);
    
    void supprimerObserve(IDoubleObservable obs);
}
