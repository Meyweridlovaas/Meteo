/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import meteo.CapteurAvecAlgorithme;
import meteo.MegaCapteur;

/**
 * FXML Controller class
 *
 * @author vagonon1
 */
public class MainWindowController implements Initializable {
    
    ObservableList<CapteurAvecAlgorithme> capteursAlgo =FXCollections.observableArrayList();
    ObservableList<MegaCapteur> megaCapteurs =FXCollections.observableArrayList();
    ObservableList<Fenetre> fenetres =FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void AjouterCapteurAlgo(){
        capteursAlgo.add(new CapteurAvecAlgorithme()); //à compléter
    }
    
    @FXML
    public void AjouterMegaCapteur(){
        
    }
    
    @FXML
    public void AjouterFenetre(){
        
    }
    
    @FXML
    public void SupprimerCapteurAlgo(){
        
    }
    
    @FXML
    public void SupprimerMegaCapteur(){
        
    }
    
    @FXML
    public void SupprimerFenetre(){
        
    }
    
    @FXML
    public void ModifierCapteurAlgo(){
        
    }
    
    @FXML
    public void ModifierMegaCapteur(){
        
    }
    
    @FXML
    public void ModifierFenetre(){
        
    }
    
}
