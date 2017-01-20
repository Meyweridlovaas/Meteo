/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Fenetres.FenetresMetier.SpinnerWindowController;
import Fenetres.FenetresMetier.Fenetre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import Capteurs.CapteurAvecAlgorithme;
import Capteurs.MegaCapteur;

/**
 * FXML Controller class
 *
 * @author vagonon1
 */
public class MainWindowController implements Initializable {
    
    private static final String ARE_YOU_SUR_TEXT = "Supprimer cet objet ? ";
    
    private ObservableList<CapteurAvecAlgorithme> capteursAlgo;
    private ObservableList<MegaCapteur> megaCapteurs;
    private ObservableList<Fenetre> fenetres;

    @FXML private ListView<CapteurAvecAlgorithme> listCapt ;
    @FXML private ListView<MegaCapteur> listMegaCapt ;
    @FXML private ListView<Fenetre> listFenetre ;
    
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
    
    /**
     * appelé par le bouton "Ajouter capteur"
     * permet d'ajouter un capteur avec algorithme
     */
    @FXML
    public void AjouterCapteurAlgo(){
        CapteurAvecAlgorithme capt=new CapteurAvecAlgorithme();
        ModificationCapteurAlgoWindow win = new ModificationCapteurAlgoWindow(capt);
        win.showAndWait();
        if(!win.hasCanceled()){
            capteursAlgo.add(capt);
        }        
    }
    
    /**
     * appelé par le bouton "Ajouter méga-capteur"
     * permet d'ajouter un méga capteur
     */
    @FXML
    public void AjouterMegaCapteur(){
        MegaCapteur capt = new MegaCapteur();
        ModificationMegaCapteurController win = new ModificationMegaCapteurController(capt,capteursAlgo,megaCapteurs);
        win.showAndWait();
        if(!win.hasCalcelled()){
            megaCapteurs.add(capt);
        }        
    }
    
    /**
     * appelé par le bouton "Ajouter fenêtre"
     * permet d'ajouter une fenêtre
     */
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
    
    /**
     * appelé par le bouton "Supprimer capteur"
     * permet de supprimer un capteur avec algorithme
     */
    @FXML
    public void SupprimerCapteurAlgo(){
        Alert confirmation = new Alert(Alert.AlertType.WARNING, 
                                    ARE_YOU_SUR_TEXT+listCapt.getSelectionModel().getSelectedItem(),
                                    ButtonType.YES, ButtonType.NO);
        confirmation.showAndWait();
        if(confirmation.getResult()==ButtonType.YES){
            capteursAlgo.remove(listCapt.getSelectionModel().getSelectedIndex());
        }        
    }
    
    /**
     * appelé par le bouton "Supprimer méga-capteur"
     * permet de supprimer un méga capteur
     */
    @FXML
    public void SupprimerMegaCapteur(){
        Alert confirmation = new Alert(Alert.AlertType.WARNING, 
                                    ARE_YOU_SUR_TEXT+listMegaCapt.getSelectionModel().getSelectedItem(),
                                    ButtonType.YES, ButtonType.NO);
        confirmation.showAndWait();
        if(confirmation.getResult()==ButtonType.YES){
            megaCapteurs.remove(listMegaCapt.getSelectionModel().getSelectedIndex());
        }        
    }
    
    /**
     * appelé par le bouton "Supprimer fenêtre"
     * permet de supprimer une fenêtre
     */
    @FXML
    public void SupprimerFenetre(){
        Alert confirmation = new Alert(Alert.AlertType.WARNING, 
                                    ARE_YOU_SUR_TEXT+listFenetre.getSelectionModel().getSelectedItem(),
                                    ButtonType.YES, ButtonType.NO);
        confirmation.showAndWait();
        if(confirmation.getResult()==ButtonType.YES){
            listFenetre.getSelectionModel().getSelectedItem().close();
            fenetres.remove(listFenetre.getSelectionModel().getSelectedIndex());
        }        
    }
    
    /**
     * appelé par le bouton "Modifier capteur"
     * permet de modifier un capteur avec algorithme
     */
    @FXML
    public void ModifierCapteurAlgo(){        
        ModificationCapteurAlgoWindow win = new ModificationCapteurAlgoWindow(listCapt.getSelectionModel().getSelectedItem());
        win.showAndWait();
        ObservableList<CapteurAvecAlgorithme> list=listCapt.getItems();
        listCapt.setItems(null);
        listCapt.setItems(list);
        listCapt.getSelectionModel().selectFirst();
    }
    
    /**
     * appelé par le bouton "Modifier méga-capteur"
     * permet de modifier un méga capteur
     */
    @FXML
    public void ModifierMegaCapteur(){
        ModificationMegaCapteurController win = new ModificationMegaCapteurController(listMegaCapt.getSelectionModel().getSelectedItem(),capteursAlgo,megaCapteurs);
        win.show();
    }
    
    /**
     * appelé par le bouton "Modifier fenêtre"
     * permet de modifier une fenêtre
     */
    @FXML
    public void ModifierFenetre(){
        ModifierFenetre(listFenetre.getSelectionModel().getSelectedItem());
    }
    
    /**
     * permet de modifier une fenêtre
     * 
     * @param fenetre
     * la fenêtre à modifier
     * 
     * @return faux si l'opération a été annulée, vrai sinon
     */
    private boolean ModifierFenetre(Fenetre fenetre){
        ModificationFenetreWindowController win=new ModificationFenetreWindowController(fenetre, capteursAlgo, megaCapteurs);
        win.showAndWait();
        return !win.hasCanceled();
    }
    
}
