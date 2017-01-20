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
public class SelectionMegaCapteurController extends Stage {
    
    private Capteur capt;
    private MegaCapteur megaCapt;
    private Integer poids;
    private boolean hasCanceled;
    private ObservableList<Capteur> capteurs;
    private ObservableList<Capteur> capteursPresents;
    private ObservableList<CapteurAvecAlgorithme> capteursAlgo;
    private ObservableList<MegaCapteur> megaCapteurs;
    
    @FXML private ListView<Capteur> listCapt;    
    
    public SelectionMegaCapteurController(MegaCapteur capt, ObservableList<CapteurAvecAlgorithme> capteursAlgo, ObservableList<MegaCapteur> megaCapteurs, ObservableList<Capteur> capteursPresents){
        
        megaCapt=capt;
        this.capteursAlgo=capteursAlgo;
        this.megaCapteurs=megaCapteurs;
        this.capteursPresents=capteursPresents;
        hasCanceled=true;
        poids=1;
        
        FXMLLoader selectionMegaCaptLoader= new FXMLLoader(getClass().getResource("SelectionMegaCapteur.fxml"));
        selectionMegaCaptLoader.setController(this); 
        
        try{
            setScene(new Scene(selectionMegaCaptLoader.load()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        capteurs=listCapt.getItems();
        capteurs.addAll(capteursAlgo);
        capteurs.addAll(megaCapteurs);
        capteurs.remove(megaCapt);
        capteurs.removeAll(capteursPresents);
    }
    
    @FXML
    public void selection(){
        hasCanceled=false;
        capt=listCapt.getSelectionModel().getSelectedItem();
        close();
    }
    
    @FXML
    public void annuler(){        
        close();
    }
    
    public Capteur getCapteur(){
        return capt;
    }
    
    public Integer getPoids(){
        return poids;
    }
    
    public boolean hasCancelled(){
        return hasCanceled;
    }
}
