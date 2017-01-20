/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres.FenetresMetier;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author vagonon1
 */
public class SpinnerWindowController extends Fenetre {

    @FXML Spinner<Double> spinner;
    SpinnerValueFactory<Double> valueFactory;
    
    /**
     * crée un SpinnerWindowController
     */
    public SpinnerWindowController(){
        
        FXMLLoader SpinnerWindowLoader= new FXMLLoader(getClass().getResource("SpinnerWindow.fxml"));
        SpinnerWindowLoader.setController(this); 
        
        try{
            setScene(new Scene(SpinnerWindowLoader.load()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Initializes the controller class.
     */
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
    
    /**
     * met à jour le spinner
     */
    @Override
    public void update() {
        valueFactory.setValue(getObserve().getTemperature());
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return "Fenetre Spinner";
    }
}
