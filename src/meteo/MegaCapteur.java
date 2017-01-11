/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import Interfaces.IDoubleObservable;
import Interfaces.IDoubleObservateur;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author vagonon1
 */
public class MegaCapteur extends Capteur implements IDoubleObservateur{
    
    private static final double TEMPERATURE_PAR_DEFAULT=0;
    private Map<Capteur,Integer> capteurs;
    
    public MegaCapteur(){
        setTemperature(TEMPERATURE_PAR_DEFAULT);
        capteurs=new HashMap<>();
    }
    
    public void ajouterCapteur(Capteur c){
        ajouterCapteur(c, 1);
    }

    public void ajouterCapteur(Capteur c, Integer poids){
        capteurs.put(c, poids);
        c.ajouterObservateur(this);
    }
    
    public void supprimerCapteur(Capteur c){
        capteurs.remove(c);
        c.supprimerObservateur(this);
    }
    
    public boolean hasCapteur(){
        return !capteurs.isEmpty();
    }
    
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

    @Override
    public void ajouterObserve(IDoubleObservable obs) {
        if(obs.getClass()==Capteur.class)
            ajouterCapteur((Capteur)obs);
    }
    
    @Override
    public void supprimerObserve(IDoubleObservable obs) {
        if(obs.getClass()==Capteur.class)
            supprimerCapteur((Capteur)obs);
    }
    
}
