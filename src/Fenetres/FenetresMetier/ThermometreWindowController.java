/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres.FenetresMetier;

import Interfaces.IDoubleObservable;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.text.Text;
import Interfaces.IDoubleObservateur;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import meteo.Capteur;


/**
 *
 * @author flsarret
 */
public class ThermometreWindowController extends Fenetre {
    
    @FXML ProgressBar thermometre;
    @FXML Text thermometreValeurMin;
    @FXML Text thermometreValeurMax;
    
    private final double COULEUR_MIN = -1;
    private final double COULEUR_MAX = 0.15;
    private final double DIFF_COULEUR = COULEUR_MAX-COULEUR_MIN;
    
    private Double min = new Double(-30);
    private Double max = new Double(50);
    
    public ThermometreWindowController(){
        FXMLLoader thermometreWindowLoader= new FXMLLoader(getClass().getResource("ThermometreWindow.fxml"));
        thermometreWindowLoader.setController(this); 
        
        try{
            setScene(new Scene(thermometreWindowLoader.load()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
    @FXML
    private void initialize(){
        
    }
    
    public void setProgres(double temperature){

        if (temperature<min){
            thermometre.setProgress(0);
        }
        else{
            double intervalleTemperature = max-min;
            double progresCourant = temperature-min;
            progresCourant = progresCourant/intervalleTemperature;
            double couleurCourante = progresCourant*DIFF_COULEUR;
            couleurCourante = COULEUR_MAX-couleurCourante;
            thermometre.setProgress(progresCourant);
            thermometre.setEffect(new ColorAdjust(couleurCourante, 0, 0, 0));
        }
    }
    
    public void setMin(Double min){
        this.min = min;
        thermometreValeurMin.setText(min.toString());
    }
    
    public void setMax(Double max){
        this.max = max;
        thermometreValeurMax.setText(max.toString());
    }
    
    
    @Override
    public void update() {
        setProgres(getObserve().getTemperature());
    }
    
    @Override
    public String toString(){
        return "Fenetre Thermomètre";
    }
}