/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import AlgorithmeTemperature.AlgorithmeTempAleatoireBorne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import meteo.Capteur;
import meteo.CapteurAvecAlgorithme;
import meteo.MegaCapteur;

/**
 * FXML Controller class
 *
 * @author vagonon1
 */
public class MainWindowController implements Initializable {
    
    ObservableList<CapteurAvecAlgorithme> capteursAlgo;
    ObservableList<MegaCapteur> megaCapteurs;
    ObservableList<Fenetre> fenetres;

    @FXML private ListView<CapteurAvecAlgorithme> listCapt ;
    @FXML private ListView<MegaCapteur> listMegaCapt ;
    @FXML private ListView<Fenetre> listFenetre ;
    
    Button b = new Button();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        capteursAlgo=listCapt.getItems();
        megaCapteurs=listMegaCapt.getItems();
        fenetres=listFenetre.getItems();
        capteursAlgo.add(new CapteurAvecAlgorithme());
        megaCapteurs.add(new MegaCapteur());
        SpinnerWindowController ctrl= new SpinnerWindowController();
        fenetres.add(ctrl);
        ctrl.show();
        listFenetre.getSelectionModel().selectFirst();
        listCapt.getSelectionModel().selectFirst();
        listMegaCapt.getSelectionModel().selectFirst();
    }
    
    @FXML
    public void AjouterCapteurAlgo(){
        CapteurAvecAlgorithme capt=new CapteurAvecAlgorithme();
        ModificationCapteurAlgoWindow win = new ModificationCapteurAlgoWindow(capt);
        win.showAndWait();
        if(!win.hasCanceled()){
            capteursAlgo.add(capt);
        }        
    }
    
    @FXML
    public void AjouterMegaCapteur(){
        
    }
    
    @FXML
    public void AjouterFenetre(){
        CreationFenetreWindowController win = new CreationFenetreWindowController();
        win.showAndWait();
        Fenetre fenetre=win.getFenetre();
        if(!win.hasCanceled()){
            if(ModifierFenetre(fenetre)){
                fenetres.add(fenetre);
                fenetre.setResizable(false);
                fenetre.show();
            }            
        }
    }
    
    @FXML
    public void SupprimerCapteurAlgo(){
        capteursAlgo.remove(listCapt.getSelectionModel().getSelectedIndex());
    }
    
    @FXML
    public void SupprimerMegaCapteur(){
        megaCapteurs.remove(listMegaCapt.getSelectionModel().getSelectedIndex());
    }
    
    @FXML
    public void SupprimerFenetre(){
        fenetres.remove(listFenetre.getSelectionModel().getSelectedIndex());
    }
    
    @FXML
    public void ModifierCapteurAlgo(){        
        ModificationCapteurAlgoWindow win = new ModificationCapteurAlgoWindow(listCapt.getSelectionModel().getSelectedItem());
        win.showAndWait();
        ObservableList<CapteurAvecAlgorithme> list=listCapt.getItems();
        listCapt.setItems(null);
        listCapt.setItems(list);
        listCapt.getSelectionModel().selectFirst();
    }
    
    @FXML
    public void ModifierMegaCapteur(){
        
    }
    
    @FXML
    public void ModifierFenetre(){
        ModifierFenetre(listFenetre.getSelectionModel().getSelectedItem());
    }
    
    private boolean ModifierFenetre(Fenetre fenetre){
        ModificationFenetreWindowController win=new ModificationFenetreWindowController(fenetre, capteursAlgo, megaCapteurs);
        win.showAndWait();
        return !win.hasCanceled();
    }
    
}
