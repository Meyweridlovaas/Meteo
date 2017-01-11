/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vagonon1
 */
public class ThreadCapteur extends Thread {
    private CapteurAvecAlgorithme capteur;
    private long tempsAttente;

    public ThreadCapteur(CapteurAvecAlgorithme capteur, double tempsAttente) {
        this.capteur = capteur;
        this.tempsAttente = (long)(tempsAttente*1000);
        this.start();
    }    
    
    @Override
    public void run(){
        while(true){
            try {
                sleep(tempsAttente);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCapteur.class.getName()).log(Level.SEVERE, null, ex);
            }
            capteur.setTemperature();
        }
    }
    
    
}
