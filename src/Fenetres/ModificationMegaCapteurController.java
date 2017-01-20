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
    
    @FXML
    public void ok(){
        hasCanceled=false;
        close();
    }
    
    @FXML
    public void annuler(){
        close();
    }
    
    @FXML
    public void ajoutCapt(){
        SelectionMegaCapteurController win=new SelectionMegaCapteurController(capt,capteursAlgo,megaCapteurs,capteurs);
        win.showAndWait();
        if(!win.hasCancelled()){
            capt.ajouterCapteur(win.getCapteur(),win.getPoids());
            capteurs.add(win.getCapteur());
        }       
    }
    
    @FXML
    public void retirerCapt(){
        capt.supprimerCapteur(listCapt.getSelectionModel().getSelectedItem());
        capteurs.remove(listCapt.getSelectionModel().getSelectedItem());
        selectionChanged();
    }
    
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
    
    @FXML
    public void selectionChanged(){
        tfPoids.setText(capt.getPoids(listCapt.getSelectionModel().getSelectedItem()).toString());
    }
    
    public boolean hasCalcelled(){
        return hasCanceled;
    }
    
}
