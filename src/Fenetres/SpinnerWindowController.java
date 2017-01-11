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
import meteo.Capteur;

/**
 * FXML Controller class
 *
 * @author vagonon1
 */
public class SpinnerWindowController extends Fenetre implements Initializable, IDoubleObservateur {

    /**
     * Initializes the controller class.
     */
    @FXML Spinner<Double> spinner;
    SpinnerValueFactory<Double> valueFactory;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        valueFactory.setValue(observe.getTemperature());
    }
}
