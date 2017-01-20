/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capteurs;

import Interfaces.IDoubleObservable;
import Interfaces.IDoubleObservateur;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author vagonon1
 */
public class MegaCapteur extends Capteur implements IDoubleObservateur{
    
    private static final double TEMPERATURE_PAR_DEFAULT=0;
    private Map<Capteur,Integer> capteurs;
    
    /**
     * crée un MegaCapteur
     */
    public MegaCapteur(){
        setTemperature(TEMPERATURE_PAR_DEFAULT);
        capteurs=new HashMap<>();
    }
    
    /**
     * ajoute un capteur
     * 
     * @param c 
     * capteur à ajouter
     */
    public void ajouterCapteur(Capteur c){
        ajouterCapteur(c, 1);
    }
    
    /**
     * ajoute un capteur avec un poids
     * 
     * @param c
     * capteur à ajouter
     * 
     * @param poids 
     * poids correspondant
     */
    public void ajouterCapteur(Capteur c, Integer poids){
        capteurs.put(c, poids);
        c.ajouterObservateur(this);
    }
    
    /**
     * supprime un capteur
     * 
     * @param c 
     * capteur à supprimer
     */
    public void supprimerCapteur(Capteur c){
        capteurs.remove(c);
        c.supprimerObservateur(this);
    }
    
    /**
     * retourne la présence de capteur dans le méga capteur
     * 
     * @return true si le méga capteur a un capteur, false sinon
     */
    public boolean hasCapteur(){
        return !capteurs.isEmpty();
    }
    
    /**
     * met à jour la température
     */
    @Override
    public void update() {        
        int poidsTotal=0;
        double temp=0;
        if(hasCapteur()){            
            for(Entry<Capteur,Integer> e : capteurs.entrySet()){
                temp+=(e.getKey().getTemperature()*e.getValue());
                poidsTotal+=e.getValue();
            }       
            setTemperature(temp/poidsTotal);
        }        
    }   
    
    /**
     * ajoute un observateur
     * 
     * @param obs 
     * observateur à ajouter
     */
    @Override
    public void ajouterObserve(IDoubleObservable obs) {
        if(obs.getClass()==Capteur.class)
            ajouterCapteur((Capteur)obs);
    }
    
    /**
     * supprime un observateur
     * 
     * @param obs 
     * observateur à supprimer
     */
    @Override
    public void supprimerObserve(IDoubleObservable obs) {
        if(obs.getClass()==Capteur.class)
            supprimerCapteur((Capteur)obs);
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return "Méga capteur";
    }
    
    /**
     * renvoie les capteurs du méga capteur
     * 
     * @return les capteurs du méga capteur
     */
    public Set<Capteur> getCapteurs(){
        return capteurs.keySet();
    }
    
    /**
     * retourne le poids correspondant à un capteur
     * 
     * @param capt
     * capteur
     * 
     * @return le poids correspondant au capteur 
     */
    public Integer getPoids(Capteur capt){
        return capteurs.get(capt);
    }
    
    /**
     * modifie le poids correspondant à un capteur
     * 
     * @param capt
     * capteur
     * 
     * @param poids 
     * nouveau poids
     */
    public void setPoids(Capteur capt, Integer poids){
        capteurs.put(capt, poids);
    }
}
