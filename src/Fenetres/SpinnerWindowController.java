/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Interfaces.IDoubleObservable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import Interfaces.IDoubleObservateur;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import meteo.Capteur;

/**
 * FXML Controller class
 *
 * @author vagonon1
 */
public class SpinnerWindowController extends Fenetre {

    /**
     * Initializes the controller class.
     */
    @FXML Spinner<Double> spinner;
    SpinnerValueFactory<Double> valueFactory;
    
    public SpinnerWindowController(){
        
        FXMLLoader SpinnerWindowLoader= new FXMLLoader(getClass().getResource("SpinnerWindow.fxml"));
        SpinnerWindowLoader.setController(this); 
        
        try{
            setScene(new Scene(SpinnerWindowLoader.load()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
    @FXML
    private void initialize() {
        valueFactory = new SpinnerValueFactory<Double>() {
            @Override
            public void decrement(int steps) {
                setValue(getValue()-0.1);
            }

            @Override
            public void increment(int steps) {
                setValue(getValue()+0.1);                
            }
        };
        spinner.setValueFactory(valueFactory);
    }

    @Override
    public void update() {
        valueFactory.setValue(getObserve().getTemperature());
    }
    
    @Override
    public String toString(){
        return "Fenetre Spinner";
    }
}
