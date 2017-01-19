/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import meteo.Capteur;
import meteo.CapteurAvecAlgorithme;
import meteo.MegaCapteur;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ModificationFenetreWindowController extends Stage {
    
    private ObservableList<Capteur> capteurs;
    private ObservableList<CapteurAvecAlgorithme> capteursAlgo;
    private ObservableList<MegaCapteur> megaCapteurs;
    private Fenetre fenetre;
    private boolean hasCanceled;
    
    @FXML ListView<Capteur> listCapt;
    
    public ModificationFenetreWindowController(Fenetre fenetre, ObservableList<CapteurAvecAlgorithme> capteursAlgo, ObservableList<MegaCapteur> megaCapteurs){
        hasCanceled=false;
        this.fenetre=fenetre;
        this.capteursAlgo=capteursAlgo;
        this.megaCapteurs=megaCapteurs;
        
        FXMLLoader modificationWindowLoader= new FXMLLoader(getClass().getResource("ModificationFenetreWindow.fxml"));
        modificationWindowLoader.setController(this);
        
        try{
            setScene(new Scene(modificationWindowLoader.load()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        capteurs=listCapt.getItems();       
        capteurs.addAll(capteursAlgo);
        capteurs.addAll(megaCapteurs);
        listCapt.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void selection(){
        listCapt.getSelectionModel().getSelectedItem().ajouterObservateur(fenetre);
        close();
    }
    
    @FXML
    private void annuler(){
        hasCanceled=true;
        close();
    }
    
    /**
     * @return the hasCanceled
     */
    public boolean hasCanceled() {
        return hasCanceled;
    }
}
