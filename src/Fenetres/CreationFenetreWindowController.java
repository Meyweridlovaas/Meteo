/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import Fenetres.FenetresMetier.ThermometreWindowController;
import Fenetres.FenetresMetier.IconeWindowController;
import Fenetres.FenetresMetier.SpinnerWindowController;
import Fenetres.FenetresMetier.Fenetre;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class CreationFenetreWindowController extends Stage {
    
    @FXML ChoiceBox cbFenetre;
    private Fenetre fenetre;
    private boolean hasCanceled;
    
    /**
     * crée une nouvelle instance de CreationFenetreWindowController
     */
    public CreationFenetreWindowController(){
        hasCanceled=true;
        
        FXMLLoader creationWindowLoader= new FXMLLoader(getClass().getResource("CreationFenetreWindow.fxml"));
        creationWindowLoader.setController(this);
        
        try{
            setScene(new Scene(creationWindowLoader.load()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
        cbFenetre.getItems().addAll(new IconeWindowController(),new SpinnerWindowController(),new ThermometreWindowController());
        cbFenetre.getSelectionModel().selectFirst();        
    }    
    
    /**
     * appelé par le bouton "Ok"
     * valide la création de fenêtre
     */
    @FXML
    private void ok(){
        hasCanceled=false;
        fenetre=(Fenetre) cbFenetre.getSelectionModel().getSelectedItem();
        close();
    }
    
    /**
     * appelé par le bouton "Annuler"
     * annule la création de la fenêtre
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

    /**
     * @return the fenetre
     */
    public Fenetre getFenetre() {
        return fenetre;
    }
    
}
