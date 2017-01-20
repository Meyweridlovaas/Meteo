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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import meteo.Capteur;
import meteo.CapteurAvecAlgorithme;
import meteo.MegaCapteur;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ModificationMegaCapteurController extends Stage {
    
    private MegaCapteur capt;
    private ObservableList<Capteur> capteurs;
    private ObservableList<CapteurAvecAlgorithme> capteursAlgo;
    private ObservableList<MegaCapteur> megaCapteurs;
    private boolean hasCanceled;
    
    @FXML private TextField tfPoids;
    @FXML private ListView<Capteur> listCapt;
    
    /**
     * crée une instance de ModificationMegaCapteurController
     * 
     * @param capt
     * méga capteur à modifier
     * 
     * @param capteursAlgo
     * liste des capteurs avec algorithmes disponibles
     * 
     * @param megaCapteurs 
     * liste des méga capteurs disponibles
     */
    public ModificationMegaCapteurController(MegaCapteur capt, ObservableList<CapteurAvecAlgorithme> capteursAlgo, ObservableList<MegaCapteur> megaCapteurs){
        this.capt=capt;
        this.capteursAlgo=capteursAlgo;
        this.megaCapteurs=megaCapteurs;
        hasCanceled=true;
        
        FXMLLoader modificationMegaCaptLoader= new FXMLLoader(getClass().getResource("ModificationMegaCapteur.fxml"));
        modificationMegaCaptLoader.setController(this); 
        
        try{
            setScene(new Scene(modificationMegaCaptLoader.load()));
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
        capteurs.addAll(capt.getCapteurs());
    }
    
    /**
     * appelé par le bouton "Ok"
     * valide la modification du méga capteur
     */
    @FXML
    public void ok(){
        hasCanceled=false;
        close();
    }
    
    /**
     * appelé par le bouton "Annuler"
     * ferme la fenêtre
     */
    @FXML
    public void annuler(){
        close();
    }
    
    /**
     * appelé par le bouton "Ajouter Capteur"
     * permet d'ajouter un capteur au méga capteur
     */
    @FXML
    public void ajoutCapt(){
        SelectionMegaCapteurController win=new SelectionMegaCapteurController(capt,capteursAlgo,megaCapteurs,capteurs);
        win.showAndWait();
        if(!win.hasCancelled()){
            capt.ajouterCapteur(win.getCapteur(),win.getPoids());
            capteurs.add(win.getCapteur());
        }       
    }
    
    /**
     * appelé par le bouton "Retirer Capteur"
     * permet de retirer le capteur sélectionné du méga capteur
     */
    @FXML
    public void retirerCapt(){
        capt.supprimerCapteur(listCapt.getSelectionModel().getSelectedItem());
        capteurs.remove(listCapt.getSelectionModel().getSelectedItem());
        selectionChanged();
    }
    
    /**
     * appelé par le bouton "Modifier poids"
     * permet de modifier le poids du capteur sélectionné
     */
    @FXML
    public void modifPoids(){
        try {
            Integer poids=Integer.parseInt(tfPoids.getText());
            if(poids >0){
                capt.setPoids(listCapt.getSelectionModel().getSelectedItem(), poids);
            }
        }
        catch(NumberFormatException n){
            
        }
    }
    
    /**
     * appelé par clic sur la liste
     * permet de mettre à jour le poids affiché dans le TextField
     */
    @FXML
    public void selectionChanged(){
        tfPoids.setText(capt.getPoids(listCapt.getSelectionModel().getSelectedItem()).toString());
    }
    
    /** 
     * @return the hasCanceled
     */
    public boolean hasCalcelled(){
        return hasCanceled;
    }
    
}
