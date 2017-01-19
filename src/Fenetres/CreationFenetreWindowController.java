/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres;

import AlgorithmeTemperature.AlgorithmeTempAleatoire;
import AlgorithmeTemperature.AlgorithmeTempAleatoireBorne;
import AlgorithmeTemperature.AlgorithmeTempAleatoireFenetre;
import AlgorithmeTemperature.AlgorithmeTempConstant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
    
    public CreationFenetreWindowController(){
        hasCanceled=false;
        
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
    
    @FXML
    private void ok(){
        fenetre=(Fenetre) cbFenetre.getSelectionModel().getSelectedItem();
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

    /**
     * @return the fenetre
     */
    public Fenetre getFenetre() {
        return fenetre;
    }
    
}
