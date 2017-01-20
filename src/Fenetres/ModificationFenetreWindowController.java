/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Fenetres.FenetresMetier.Fenetre;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import Capteurs.Capteur;
import Capteurs.CapteurAvecAlgorithme;
import Capteurs.MegaCapteur;

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
    
    /**
     * crée une nouvelle instance de ModificationFenetreWindowController
     *  
     * @param fenetre
     * la fenêtre à modifier
     * 
     * @param capteursAlgo
     * liste des capteurs avec algorithme disponibles
     * 
     * @param megaCapteurs 
     * liste des méga capteurs disponibles
     * 
     */
    public ModificationFenetreWindowController(Fenetre fenetre, ObservableList<CapteurAvecAlgorithme> capteursAlgo, ObservableList<MegaCapteur> megaCapteurs){
        hasCanceled=true;
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
    
    /**
     * appelé par le bouton "Sélectionner capteur"
     * permet de valider la sélection du capteur
     */
    @FXML
    private void selection(){
        hasCanceled=false;
        listCapt.getSelectionModel().getSelectedItem().ajouterObservateur(fenetre);
        close();
    }
    
    /**
     * appelé par le bouton "Annuler"
     * permet d'annuler la sélection de capteur
     */
    @FXML
    private void annuler(){        
        close();
    }
    
    /**
     * @return the hasCanceled
     */
    public boolean hasCanceled() {
        return hasCanceled;
    }
}
