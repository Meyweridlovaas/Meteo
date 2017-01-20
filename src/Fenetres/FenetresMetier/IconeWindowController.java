package Fenetres.FenetresMetier;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
        

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author flsarret
 */
public class IconeWindowController extends Fenetre {
    
    @FXML private ImageView icone;
    
    private SelectionneurImage selectionneurImage;
    
    /**
     * crée un IconeWindowController
     */
    public IconeWindowController(){
        selectionneurImage=new Selectionneur2();
        
        FXMLLoader iconeWindowLoader= new FXMLLoader(getClass().getResource("IconeWindow.fxml"));
        iconeWindowLoader.setController(this); 
        
        try{
            setScene(new Scene(iconeWindowLoader.load()));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private void initialize(){
        
    }
    
    /**
     * @return le selectionneurImage
     */
    public SelectionneurImage getSelectionneurImage() {
        return selectionneurImage;        
    }
    
    /**
     * modifie le selectionneurImage
     * 
     * @param selectionneurImage 
     * nouveau selectionneurImage
     */
    public void setSelectionneurImage(SelectionneurImage selectionneurImage) {
        this.selectionneurImage = selectionneurImage;
    } 
    
    /**
     * modifie l'image
     * 
     * @param temperature 
     * temérature déterminant l'image
     */
    @FXML
    public void ChoixImage(double temperature){
        icone.setImage(selectionneurImage.selectionImage(temperature));
    }
    
    /**
     * met à jour l'icone
     */
    @Override
    public void update() {        
        ChoixImage(getObserve().getTemperature());
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString(){
        return "Fenetre Icone";
    }
}
