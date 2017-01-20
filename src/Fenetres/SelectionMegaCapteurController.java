/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

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
    
    /**
     * crée un SelectionMegaCapteurController
     * 
     * @param capt
     * méga capteur ne devant pas être ajouté car celui auquel l'ajout sera fait
     * 
     * @param capteursAlgo
     * liste des capteurs avec algorithmes disponibles
     * 
     * @param megaCapteurs
     * liste des méga capteurs disponibles
     * 
     * @param capteursPresents 
     * liste des capteurs ne devant pas être ajoutés car déjà présents
     */
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
    
    /**
     * appelé par le bouton "Sélectionner capteur"
     * permet de valider la sélection
     */
    @FXML
    public void selection(){
        hasCanceled=false;
        capt=listCapt.getSelectionModel().getSelectedItem();
        close();
    }
    
    /**
     * appelé par le bouton "Annuler"
     * permet d'annuler la sélection
     */
    @FXML
    public void annuler(){        
        close();
    }
    
    /**
     * @return the capt
     */
    public Capteur getCapteur(){
        return capt;
    }
    
    /**
     * @return the poids
     */
    public Integer getPoids(){
        return poids;
    }
    
    /**
     * @return the hasCanceled 
     */
    public boolean hasCancelled(){
        return hasCanceled;
    }
}
