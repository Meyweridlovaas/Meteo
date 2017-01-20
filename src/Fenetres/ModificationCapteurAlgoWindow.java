/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import AlgorithmeTemperature.AlgorithmeTempAleatoire;
import AlgorithmeTemperature.AlgorithmeTempAleatoireFenetre;
import AlgorithmeTemperature.AlgorithmeTempConstant;
import AlgorithmeTemperature.AlgorithmeTempAleatoireBorne;
import AlgorithmeTemperature.AlgorithmeTemperature;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import meteo.CapteurAvecAlgorithme;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ModificationCapteurAlgoWindow extends Stage {
    
    private CapteurAvecAlgorithme capteur;
    private SpinnerValueFactory<Double> valueFactory;
    private boolean hasCanceled;
    
    @FXML Spinner<Double> spinMAJ;
    @FXML ChoiceBox cbAlgo;
    @FXML TextField tfParam1;
    @FXML TextField tfParam2;

    public ModificationCapteurAlgoWindow(CapteurAvecAlgorithme capt){        
        capteur=capt;
        hasCanceled=true;
        
        FXMLLoader modificationWindowLoader= new FXMLLoader(getClass().getResource("ModificationCapteurAlgoWindow.fxml"));
        modificationWindowLoader.setController(this); 
        
        try{
            setScene(new Scene(modificationWindowLoader.load()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
    @FXML
    private void initialize(){
        valueFactory=new SpinnerValueFactory<Double>() {
            @Override
            public void decrement(int steps) {
                if(getValue()>0.5){
                    setValue(getValue()-0.5);
                }                
            }

            @Override
            public void increment(int steps) {
                setValue(getValue()+0.5);
            }
        };
        spinMAJ.setValueFactory(valueFactory);
        valueFactory.setValue(capteur.getIntervalleMAJ());
        cbAlgo.getItems().addAll(capteur.getAlgorithme(),new AlgorithmeTempAleatoire(),new AlgorithmeTempConstant(),new AlgorithmeTempAleatoireFenetre(),new AlgorithmeTempAleatoireBorne());
        cbAlgo.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void annuler(){        
        close();
    }
    
    @FXML
    private void ok(){
        
        AlgorithmeTemperature nouvelAlgo=(AlgorithmeTemperature)(cbAlgo.getSelectionModel().getSelectedItem());
        try {
            double param1=Double.parseDouble(tfParam1.getText());
            double param2;
            if(tfParam2.getText().isEmpty()){
                nouvelAlgo.setParametres(param1);
            }else{
                param2=Double.parseDouble(tfParam2.getText());
                nouvelAlgo.setParametres(param1,param2);
            }             
        }
        catch(NumberFormatException n){
            
        }       
        capteur.setAlgorithme(nouvelAlgo);
        capteur.setIntervalleMAJ(valueFactory.getValue());
        hasCanceled=false;
        close();
    }

    /**
     * @return the hasCanceled
     */
    public boolean hasCanceled() {
        return hasCanceled;
    }
}
