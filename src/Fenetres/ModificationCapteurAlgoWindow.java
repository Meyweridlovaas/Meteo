/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import AlgorithmeTemperature.AlgorithmeTempAleatoire;
import AlgorithmeTemperature.AlgorithmeTempConstant;
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
    
    private DoubleProperty intervalleMAJ= new SimpleDoubleProperty();
    private CapteurAvecAlgorithme capteur;
    private SpinnerValueFactory<Double> valueFactory;
    
    @FXML
    Spinner<Double> spinMAJ;
    @FXML
    ChoiceBox cbAlgo;

    public ModificationCapteurAlgoWindow(CapteurAvecAlgorithme capt){
        //intervalleMAJ.setValue(capt.getIntervalleMAJ());
        capteur=capt;
        
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
        //intervalleMAJ.setValue(capteur.getIntervalleMAJ());
        //spinMAJ
        cbAlgo.getItems().addAll(new AlgorithmeTempAleatoire(),new AlgorithmeTempConstant());
        cbAlgo.getSelectionModel().selectFirst();
    }
    
}
