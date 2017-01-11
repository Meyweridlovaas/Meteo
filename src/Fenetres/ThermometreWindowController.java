/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Interfaces.IDoubleObservable;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.text.Text;
import Interfaces.IDoubleObservateur;
import meteo.Capteur;


/**
 *
 * @author flsarret
 */
public class ThermometreWindowController extends Fenetre implements IDoubleObservateur{
    
    @FXML ProgressBar thermometre;
    @FXML Text thermometreValeurMin;
    @FXML Text thermometreValeurMax;
    private final Double MIN = new Double(-30);
    private final Double MAX = new Double(50);
    private final double COULEUR_MIN = -1;
    private final double COULEUR_MAX = 0.15;

    
    public void setProgres(double temperature){
        thermometreValeurMin.setText(MIN.toString());
        thermometreValeurMax.setText(MAX.toString());
        if (temperature<MIN){
            thermometre.setProgress(0);
        }
        else{
            double couleurIntervalle = COULEUR_MAX-COULEUR_MIN;
            double intervalleTemperature = MAX-MIN;
            double progresCourant = temperature-MIN;
            progresCourant = progresCourant/intervalleTemperature;
            double couleurCourante = progresCourant*couleurIntervalle;
            couleurCourante = COULEUR_MAX-couleurCourante;
            thermometre.setProgress(progresCourant);
            thermometre.setEffect(new ColorAdjust(couleurCourante, 0, 0, 0));
        }
    }

    @Override
    public void update() {
        setProgres(observe.getTemperature());
    }   
}
