/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    
    @FXML 
    TextField tfMAJ;

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
    
}
