package Fenetres;

import Interfaces.IDoubleObservable;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import Interfaces.IDoubleObservateur;
import meteo.Capteur;
        

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author flsarret
 */
public class IconeWindowController extends Fenetre implements IDoubleObservateur {
    @FXML private ImageView icone;
    
    private SelectionneurImage selectionneurImage;

    public SelectionneurImage getSelectionneurImage() {
        return selectionneurImage;        
    }

    public void setSelectionneurImage(SelectionneurImage selectionneurImage) {
        this.selectionneurImage = selectionneurImage;
    }
    
    public IconeWindowController(){}
    
    @FXML
    public void ChoixImage(double temperature){
        icone.setImage(selectionneurImage.selectionImage(temperature));
    }

    @Override
    public void update() {
        //ChoixImage(d);
        ChoixImage(observe.getTemperature());
    }
}
